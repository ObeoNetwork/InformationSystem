/*******************************************************************************
 * Copyright (c) 2006, 2012 Obeo. All Rights Reserved.
 *
 * This file is part of Obeo Ecore Binding.
 *
 * This software and the attached documentation are the exclusive ownership
 * of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights
 * of intellectual ownership, including the section "Titre II Droits des auteurs (Articles L121-1 L123-12)"
 * By installing this software, you acknowledge being aware of these rights and
 * accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 *
 * Should you not agree with these terms, you must stop using this software and give it back to its legitimate owner.
 *
 * 
 * Contributors:
 *     Hugo Marchadour (Obeo) - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.ecorebinding.presentation;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.obeonetwork.dsl.ecorebinding.BClass;
import org.obeonetwork.dsl.ecorebinding.BDataType;
import org.obeonetwork.dsl.ecorebinding.BEnum;
import org.obeonetwork.dsl.ecorebinding.BEnumLiteral;
import org.obeonetwork.dsl.ecorebinding.BFeature;
import org.obeonetwork.dsl.ecorebinding.BModel;
import org.obeonetwork.dsl.ecorebinding.BOperation;
import org.obeonetwork.dsl.ecorebinding.BPackage;
import org.obeonetwork.dsl.ecorebinding.BParameter;
import org.obeonetwork.dsl.ecorebinding.EcorebindingFactory;

public class EcorebindingModelWizardSpec extends EcorebindingModelWizard {
	private EcoreSelectionWizardPage ecoreSelectionWizardPage;
	
	@Override
	public void addPages() {
		// Create a page, set the title, and the initial model file name.
		//
		newFileCreationPage = new EcorebindingModelWizardNewFileCreationPage("Whatever", selection);
		newFileCreationPage.setTitle(EcorebindingEditorPlugin.INSTANCE.getString("_UI_EcorebindingModelWizard_label"));
		newFileCreationPage.setDescription(EcorebindingEditorPlugin.INSTANCE.getString("_UI_EcorebindingModelWizard_description"));
		newFileCreationPage.setFileName(EcorebindingEditorPlugin.INSTANCE.getString("_UI_EcorebindingEditorFilenameDefaultBase") + "." + FILE_EXTENSIONS.get(0));
		addPage(newFileCreationPage);

		initialObjectCreationPage = new EcorebindingModelWizardInitialObjectCreationPage("Whatever2");
		
		// Try and get the resource selection to determine a current directory for the file dialog.
		//
		if (selection != null && !selection.isEmpty()) {
			// Get the resource...
			//
			Object selectedElement = selection.iterator().next();
			if (selectedElement instanceof IResource) {
				// Get the resource parent, if its a file.
				//
				IResource selectedResource = (IResource)selectedElement;
				String fileName = selectedResource.getFullPath().removeFileExtension().lastSegment();
				if (selectedResource.getType() == IResource.FILE) {
					selectedResource = selectedResource.getParent();
				}

				// This gives us a directory...
				//
				if (selectedResource instanceof IFolder || selectedResource instanceof IProject) {
					// Set this for the container.
					//
					newFileCreationPage.setContainerFullPath(selectedResource.getFullPath());

					// Make up a unique new name here.
					//
					String defaultModelBaseFilename = fileName;
					String defaultModelFilenameExtension = FILE_EXTENSIONS.get(0);
					String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
					for (int i = 1; ((IContainer)selectedResource).findMember(modelFilename) != null; ++i) {
						modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
					}
					newFileCreationPage.setFileName(modelFilename);
				}
			}
		}
		
		if (this.selection != null && !this.selection.isEmpty()) {
			Object selectedElement = selection.iterator().next();
			if (selectedElement instanceof IFile && "ecore".equals(((IFile)selectedElement).getFileExtension())) {
				this.ecoreSelectionWizardPage = new EcoreSelectionWizardPage(((IFile)selectedElement).getLocation());
			} else {
				this.ecoreSelectionWizardPage = new EcoreSelectionWizardPage();
			}
		} else {			
			this.ecoreSelectionWizardPage = new EcoreSelectionWizardPage();
		}
		this.addPage(ecoreSelectionWizardPage);
	}
	
	/**
	 *  (non-Javadoc)
	 * @see org.obeonetwork.dsl.ecorebinding.presentation.EcorebindingModelWizard#createInitialModel()
	 */
	@Override
	protected EObject createInitialModel() {
		IPath ecoreFilePath = this.ecoreSelectionWizardPage.getEcoreFilePath();
		ResourceSet ecorers = new ResourceSetImpl();
		Resource ecoreResource = ecorers.getResource(URI.createFileURI(ecoreFilePath.toFile().getAbsolutePath()), true);
		try {
			ecoreResource.load(new HashMap<String, String>());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		ResourceSet rs = new ResourceSetImpl();
		IPath ecoreBindingModelPath = ecoreFilePath;
		ecoreBindingModelPath = ecoreFilePath.removeFileExtension().addFileExtension("ecorebinding");
		Resource resource = rs.createResource(URI.createFileURI(ecoreBindingModelPath.toFile().getAbsolutePath()));
		
		BModel ecoreBindingModel = EcorebindingFactory.eINSTANCE.createBModel();
		
		List<EObject> contents = ecoreResource.getContents();
		for (EObject eObject : contents) {			
			// We only support EPackage as root element.
			if (eObject instanceof EPackage) {
				EPackage rootPackage = (EPackage) eObject;
				BPackage ecoreBindingPackage = EcorebindingFactory.eINSTANCE.createBPackage();
				ecoreBindingPackage.setEcorePackage(rootPackage);
				ecoreBindingModel.getBPackages().add(ecoreBindingPackage);
				
				explore(rootPackage, ecoreBindingPackage);
			} else {
				throw new IllegalArgumentException("The Ecore Binding only supports EPackage as root element");
			}
		}
		
		resource.getContents().add(ecoreBindingModel);
		try {
			resource.save(new HashMap<String, String>());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ecoreBindingModel;
	}
	
	
	/**
	 * Expore the EPackage and init the BPackage.
	 * @param ePackage The ecore Package input to read
	 * @param bPackage The Binding Package to build
	 */
	private static void explore(EPackage ePackage, BPackage bPackage) {
		EList<EClassifier> eClassifiers = ePackage.getEClassifiers();
		for (EClassifier eClassifier : eClassifiers) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				
				// Create BClass
				BClass bClass = EcorebindingFactory.eINSTANCE.createBClass();
				bClass.setEcoreClass(eClass);
				bPackage.getBClasses().add(bClass);
				bPackage.getBClassifiers().add(bClass);
				explore(eClass, bClass);
				
			} else if (eClassifier instanceof EEnum) {
				EEnum eEnum = (EEnum)eClassifier;
				
				// Create BEnum
				BEnum bEnum = EcorebindingFactory.eINSTANCE.createBEnum();
				bEnum.setEcoreEnum(eEnum);
				bEnum.setEcoreDataType(eEnum);
				bPackage.getBEnums().add(bEnum);
				bPackage.getBClassifiers().add(bEnum);
				List<EEnumLiteral> eLiterals = eEnum.getELiterals();
				
				
				for (EEnumLiteral eLiteral : eLiterals) {
					// Create BEnumLiteral
					BEnumLiteral bEnumLiteral = EcorebindingFactory.eINSTANCE.createBEnumLiteral();
					bEnumLiteral.setBEnum(bEnum);
					bEnumLiteral.setEcoreEnumLiteral(eLiteral);
				}
				
			} else if (eClassifier instanceof EDataType) {
				EDataType eDataType = (EDataType)eClassifier;
				
				// Create BDataType
				BDataType bDataType = EcorebindingFactory.eINSTANCE.createBDataType();
				bDataType.setEcoreDataType(eDataType);
				bPackage.getBDataTypes().add(bDataType);
				bPackage.getBClassifiers().add(bDataType);
			}
		}
		
		List<EPackage> eSubpackages = ePackage.getESubpackages();
		for (EPackage subEPackage : eSubpackages) {
			
			// Create BPackage
			BPackage subBPackage = EcorebindingFactory.eINSTANCE.createBPackage();
			subBPackage.setEcorePackage(subEPackage);
			bPackage.getNestedBPackages().add(subBPackage);
			explore(subEPackage, subBPackage);
		}
	}
	
	/**
	 * Expore the EClass and init the BClass.
	 * @param eClass The ecore Class input to read
	 * @param bClass The Binding Class to build
	 */
	private static void explore(EClass eClass, BClass bClass) {
		EList<EStructuralFeature> eStructuralFeatures = eClass.getEStructuralFeatures();
		for (EStructuralFeature eStructuralFeature : eStructuralFeatures) {
			
			// Create BFeature
			BFeature bFeature = EcorebindingFactory.eINSTANCE.createBFeature();
			bFeature.setBClass(bClass);
			bFeature.setEcoreFeature(eStructuralFeature);
		}

		EList<EOperation> eOperations = eClass.getEOperations();
		for (EOperation eOperation : eOperations) {
			
			// Create BOperation
			BOperation bOperation = EcorebindingFactory.eINSTANCE.createBOperation();
			bOperation.setBClass(bClass);
			bOperation.setEcoreOperation(eOperation);
			
			EList<EParameter> eParameters = eOperation.getEParameters();
			for (EParameter eParameter : eParameters) {
				// Create BParameter
				BParameter bParameter = EcorebindingFactory.eINSTANCE.createBParameter();
				bParameter.setBOperation(bOperation);
				bParameter.setEcoreParameter(eParameter);
			}
		}
	}
}
