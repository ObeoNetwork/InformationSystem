/*******************************************************************************
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.gouv.mindef.safran.database.ui.compare.viewer.content;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.AttributeChange;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceState;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.ReferenceChange;
import org.eclipse.emf.compare.rcp.ui.EMFCompareRCPUIPlugin;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.ICompareAccessor;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.ITypedElement;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.impl.AbstractTypedElementAdapter;
import org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.TypeConstants;
import org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.accessor.factory.impl.AbstractAccessorFactory;
import org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.item.impl.MergeViewerItem;
import org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.item.impl.MergeViewerItem.Container;
import org.eclipse.emf.compare.rcp.ui.internal.util.MergeViewerUtil;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.IMergeViewerItem;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Image;
import org.obeonetwork.dsl.database.dbevolution.DBDiff;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

public class DBDiffAccessorFactory extends AbstractAccessorFactory {

	
	public DBDiffAccessorFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isFactoryFor(Object target) {
		return target instanceof DBDiff;
	}

	@Override
	public ITypedElement createLeft(AdapterFactory adapterFactory, Object target) {
		return createLeft(adapterFactory, (DBDiff)target);
	}

	@Override
	public ITypedElement createRight(AdapterFactory adapterFactory,
			Object target) {
		return createRight(adapterFactory, (DBDiff)target);
	}

	@Override
	public ITypedElement createAncestor(AdapterFactory adapterFactory,
			Object target) {
		return createAncestor(adapterFactory, (DBDiff)target);
	}
	
	private static ITypedElement createLeft(AdapterFactory adapterFactory, DBDiff diff) {
		return createAccessor(adapterFactory, diff, MergeViewerSide.LEFT);
	}
	
	private static ITypedElement createAccessor(AdapterFactory adapterFactory, DBDiff diff, MergeViewerSide side) {
		Diff delegate = Iterables.getFirst(diff.getRefinedBy(), null);	
		
		// If ADD/DELETE or Attribute change
		if (isContainementDiff(diff) || diff.getRefinedBy().size() == 1 && delegate instanceof AttributeChange) {
			IAccessorFactory factory = getAccessorFactoryForTarget(delegate);
			if (factory != null) {
				switch (side) {
					case LEFT:					
						return factory.createLeft(adapterFactory, delegate);
					case RIGHT:					
						return factory.createRight(adapterFactory, delegate);
					case ANCESTOR:
						return factory.createAncestor(adapterFactory, delegate);
				}	
			}			
		} else if (diff.getTarget() != null) {
			// alter case
//			Match match = getRelatedMatch(diff);
//			if (match != null) {
//				return new MatchAccessor(adapterFactory, match, side);
//			}
			return new AlterContainmentReferenceChangeAccessor(adapterFactory, diff, side);
		}
				
		return null;
	}
	
	private static class AlterContainmentReferenceChangeAccessor extends AbstractTypedElementAdapter implements ICompareAccessor {

		private final DBDiff fDiff;

		private final MergeViewerSide fSide;

		private final Match fOwnerMatch;
		
		public AlterContainmentReferenceChangeAccessor(AdapterFactory adapterFactory,
				DBDiff diff, MergeViewerSide side) {
			super(adapterFactory);
			fDiff = diff;
			fSide = side;
			fOwnerMatch = diff.getMatch();
		}
		
		public Comparison getComparison() {
			return fOwnerMatch.getComparison();
		}
		
		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.compare.rcp.ui.mergeviewer.accessor.IStructuralFeatureAccessor#getInitialItem()
		 */
		public EObject getEObject(MergeViewerSide side) {
			return MergeViewerUtil.getEObject(fOwnerMatch, side);
		}
		
		/**
		 * @return the fSide
		 */
		protected final MergeViewerSide getSide() {
			return fSide;
		}
		
		/**
		 * @return the fDiff
		 */
		protected final Diff getInitialDiff() {
			return fDiff;
		}
		
		@Override
		public Image getImage() {
			return null;
		}
		
		@Override
		public String getName() {
			return this.getClass().getName();
		}
		
		@Override
		public String getType() {
			return TypeConstants.TYPE_ETREE_DIFF;
		}
		
		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.compare.rcp.ui.mergeviewer.accessor.ICompareAccessor#getInitialItem()
		 */
		public IMergeViewerItem getInitialItem() {
			EObject diffValue = fDiff.getTarget();
			Match match = getComparison().getMatch(diffValue);

			if (match == null && DifferenceState.MERGED == fDiff.getState()
					&& MergeViewerSide.ANCESTOR != getSide()) {
				match = getMatchWithNullValues(fDiff.getMatch());
			}
			if (match != null) {
				return new MergeViewerItem.Container(getComparison(), fDiff, match, getSide(),
						getRootAdapterFactory());
			}
			return null;
		}

		/**
		 * After merging a diff which will lead to have an insertion point on both sides, the match associated
		 * with this diff will be unreacheable because its left and right sides will be null. This method will
		 * find this match.
		 * 
		 * @param match
		 * @return the match associated with the given merged diff.
		 */
		private Match getMatchWithNullValues(Match match) {
			for (Match subMatch : match.getSubmatches()) {
				if (subMatch.getLeft() == null && subMatch.getRight() == null) {
					return subMatch;
				}
			}
			return null;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.compare.rcp.ui.mergeviewer.accessor.ICompareAccessor#getItems()
		 */
		public ImmutableList<? extends IMergeViewerItem> getItems() {
			final ImmutableList.Builder<IMergeViewerItem> ret = ImmutableList.builder();

			ret.add(getContainer(fDiff));
				
			return ret.build();
		}
		
		private IMergeViewerItem.Container getContainer(Diff diff) {
			EObject value = null;
			if (diff instanceof DBDiff) {
				value = ((DBDiff) diff).getTarget();
			} else if (diff instanceof ReferenceChange) {
				value = ((ReferenceChange) diff).getValue();
			}
			if (value != null) {
				Match matchValue = fOwnerMatch.getComparison().getMatch(value);
				if (getSide() != MergeViewerSide.ANCESTOR
						|| (getSide() == MergeViewerSide.ANCESTOR && matchValue.getOrigin() != null)) {
					IMergeViewerItem.Container container = new Container(getComparison(), diff, matchValue.getLeft(), matchValue
						.getRight(), matchValue.getOrigin(), getSide(), getRootAdapterFactory());
					return container;
				}
			}
			return null;
		}
		
	}
	
	private static ITypedElement createRight(AdapterFactory adapterFactory, DBDiff diff) {
		return createAccessor(adapterFactory, diff, MergeViewerSide.RIGHT);
	}
	
	private static ITypedElement createAncestor(AdapterFactory adapterFactory, DBDiff diff) {
		return createAccessor(adapterFactory, diff, MergeViewerSide.ANCESTOR);
	}
	
	private static Match getRelatedMatch(DBDiff target) {
		return target.getMatch().getComparison().getMatch(target.getTarget());
	}
	
	private static IAccessorFactory getAccessorFactoryForTarget(Object object) {
		IAccessorFactory.Registry factoryRegistry = EMFCompareRCPUIPlugin.getDefault()
				.getAccessorFactoryRegistry();
		return factoryRegistry.getHighestRankingFactory(object);
	}
	
	private static boolean isContainementDiff(DBDiff diff) {
		return diff.eClass().getName().startsWith("Add") || diff.eClass().getName().startsWith("Remove");
			
	}

}
