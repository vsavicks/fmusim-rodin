/**
 * 
 */
package ac.soton.fmusim.components.ui.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EcoreFactoryImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
//import org.eclipse.gmf.internal.bridge.resolver.StructureResolver;
//import org.eclipse.gmf.internal.bridge.wizards.Messages;
//import org.eclipse.gmf.internal.bridge.wizards.WizardUtil;
//import org.eclipse.gmf.internal.bridge.wizards.pages.simple.DefinitionPage;
//import org.eclipse.gmf.internal.bridge.wizards.pages.simple.DomainModelSourceImpl;
//import org.eclipse.gmf.internal.bridge.wizards.pages.simple.StructureBuilder;
//import org.eclipse.gmf.internal.bridge.wizards.pages.simple.ToolDefBuilder;
//import org.eclipse.gmf.internal.common.ui.ResourceLocationProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

/**
 * @author vitaly
 *
 */
public class ImportWizard extends Wizard implements IImportWizard {

	private IWorkbench workbench;
	private IStructuredSelection selection;

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		// TODO create component on the diagram
		return false;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle("Component Import Wizard");
//		setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(GMFToolEditPlugin.INSTANCE.getImage("full/wizban/NewGMFTool")));
	}

	/**
	 * @return
	 */
	protected EObject createInitialModel() {
		return EcoreFactoryImpl.eINSTANCE.createEObject();
	}
	
	public void addPages() {
		// emf-specific
//		ResourceLocationProvider rloc = new ResourceLocationProvider(selection);
		ResourceSet resourceSet = new ResourceSetImpl();
		
//		if (selection != null && !selection.isEmpty()) {
//			Object selected = selection.getFirstElement();
//			if (selected instanceof IFile) {
//				newFileCreationPage.setFileName(WizardUtil.getDefaultFileName((IFile) selected, "gmftool")); //$NON-NLS-1$
//			}
//		}
		
//		toolingDefinitionPage = new DefinitionPage("ToolingDefinitionPage", new StructureBuilder(new StructureResolver(), false), domainModelSelectionPage) { //$NON-NLS-1$
//
//			protected DomainModelSourceImpl createDomainModelSource(EPackage contents, EClass diagramElement) {
//				if (isInReconcileMode()) {
//					return new DomainModelSourceImpl(contents, diagramElement) {
//
//						public boolean isDisabled(EObject domainElement) {
//							return ToolDefBuilder.getCreationTool(toolingModelSelectionPage.getResource().getAllContents(), domainElement) != null;
//						}
//					};
//				}
//				return super.createDomainModelSource(contents, diagramElement);
//			}
//		};
//		toolingDefinitionPage.setTitle(Messages.SimpleModelWizardToolDefinitionPageTitle);
//		toolingDefinitionPage.setDescription(Messages.SimpleModelWizardToolDefinitionPageDesc);
//		addPage(toolingDefinitionPage);
	}
}
