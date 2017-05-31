package org.obeonetwork.dsl.database.compare.tests.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.diff.DefaultDiffEngine;
import org.eclipse.emf.compare.diff.DiffBuilder;
import org.eclipse.emf.compare.diff.FeatureFilter;
import org.eclipse.emf.compare.diff.IDiffEngine;
import org.eclipse.emf.compare.diff.IDiffProcessor;
import org.eclipse.emf.compare.match.DefaultComparisonFactory;
import org.eclipse.emf.compare.match.DefaultEqualityHelperFactory;
import org.eclipse.emf.compare.match.DefaultMatchEngine;
import org.eclipse.emf.compare.match.IComparisonFactory;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.match.eobject.IEObjectMatcher;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryImpl;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryRegistryImpl;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;

public class EMFCompareUtils {

	private static EMFCompare comparator = initializeComparator();

	/**
	 * Compares two {@link Notifier} using the EMF Compare engine.
	 *
	 * @param expected
	 * @param actual
	 */
	public static Comparison compare(Notifier expected, Notifier actual) {
		final IComparisonScope scope = new DefaultComparisonScope(expected, actual, null);
		final Comparison comparison = comparator.compare(scope);
		return comparison;
	}

	/**
	 * Initializes the EMF Compare comparator.
	 *
	 * @return the EMFCompare comparator.
	 */
	private static EMFCompare initializeComparator() {
		final IEObjectMatcher matcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.NEVER);
		final IComparisonFactory comparisonFactory = new DefaultComparisonFactory(new DefaultEqualityHelperFactory());
		final IMatchEngine.Factory matchEngineFactory = new MatchEngineFactoryImpl(matcher, comparisonFactory);
		matchEngineFactory.setRanking(20);
		final IMatchEngine.Factory.Registry matchEngineRegistry = new MatchEngineFactoryRegistryImpl();
		matchEngineRegistry.add(matchEngineFactory);

		final IDiffProcessor diffProcessor = new DiffBuilder();

		final IDiffEngine diffEngine = new DefaultDiffEngine(diffProcessor) {
			@Override
			protected FeatureFilter createFeatureFilter() {
				return new FeatureFilter() {
					@Override
					protected boolean isIgnoredAttribute(EAttribute attribute) {
						if (attribute == null) {
							// If some attributes must be ignored during the
							// comparison, do it here.
							return true;
						} else {
							return super.isIgnoredAttribute(attribute);
						}
					}
				};
			}
		};

		final EMFCompare comparator = EMFCompare.builder().setDiffEngine(diffEngine)
				.setMatchEngineFactoryRegistry(matchEngineRegistry).build();
		return comparator;
	}

	public static Set<EClass> getAllDifferenceTypes(List<Diff> differences) {
		Set<EClass> differenceTypes = new HashSet<>();
		for (Diff diff : differences) {
			differenceTypes.add(diff.eClass());
		}
		return differenceTypes;
	}
}
