/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.wizards.pages.experimental;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
//import org.eclipse.gmf.internal.bridge.resolver.ContainmentClosure;
//import org.eclipse.gmf.internal.bridge.resolver.NodePattern;
//import org.eclipse.gmf.internal.bridge.resolver.StructureResolver;
//import org.eclipse.gmf.internal.bridge.resolver.TypeLinkPattern;
//import org.eclipse.gmf.internal.bridge.resolver.TypePattern;
//import org.eclipse.gmf.internal.bridge.ui.Plugin;
//import org.eclipse.gmf.internal.bridge.wizards.pages.simple.DomainModelSource;
//import org.eclipse.gmf.internal.bridge.wizards.pages.simple.ResolvedItem;
//import org.eclipse.gmf.internal.bridge.wizards.pages.simple.ResolvedItem.Resolution;

/**
 * @author vitaly
 *
 */
public class StructureBuilder {

//	private final StructureResolver resolver;
//
//	private final boolean withLabels;
//
//	private final ContainmentClosure containmentClosure;
//
//	public StructureBuilder(StructureResolver resolver, boolean withLabels) {
//		this.resolver = resolver;
//		this.withLabels = withLabels;
//		containmentClosure = Plugin.getDefault().getContaintmentClosure();
//	}
//
//	public final boolean isWithLabels() {
//		return withLabels;
//	}
//
//	/**
//	 * Entry point to the structure builder. It walks over the domain model and builds resolutions tree.
//	 */
//	public ResolvedItem process(DomainModelSource dms) {
//		ResolvedItem item = new ResolvedItem(null, dms.getContents(), null, ResolvedItem.NO_RESOLUTIONS, false); // root of the resolutions tree
//		for (Iterator<EObject> it = dms.getContents().eAllContents(); it.hasNext();) {
//			EObject next = it.next();
//			if (next instanceof EClass) {
//				item.addChild(process((EClass) next, dms));
//			}
//		}
//		return item;
//	}
//
//	protected ResolvedItem process(EClass domainClass, DomainModelSource dms) {
//		final EClass diagramClass = dms.getDiagramElement(); // containment root of diagram elements
//		final EPackage domainPackage = dms.getContents();
//		Resolution resolution;
//		Resolution[] resolutions = ResolvedItem.NODE_LINK_RESOLUTIONS; // class may be resolved only as node or link
//		TypePattern pattern = resolver.resolve(domainClass, domainPackage);
//		if (pattern instanceof NodePattern) {
//			resolution = Resolution.NODE;
//			if (diagramClass != null && !containmentClosure.contains(diagramClass, domainClass, domainPackage)) {
//				resolution = null; // class is not in diagram containment hierarchy
//			}
//		} else if (pattern instanceof TypeLinkPattern) {
//			resolution = Resolution.LINK;
//			if (diagramClass != null) {
//				TypeLinkPattern linkPattern = (TypeLinkPattern) pattern;
//				if (linkPattern.getSource() != null &&
//						!containmentClosure.contains(diagramClass, linkPattern.getSource().getEReferenceType(), domainPackage)) {
//					resolution = null; // source is not in diagram containment hierarchy
//				}
//				if (linkPattern.getTarget() != null &&
//						!containmentClosure.contains(diagramClass, linkPattern.getTarget().getEReferenceType(), domainPackage)) {
//					resolution = null; // target is not in diagram containment hierarchy
//				}
//			}
//		} else {
//			resolution = null;
//			if (domainClass.isAbstract() || domainClass.isInterface()) {
//				resolutions = ResolvedItem.NO_RESOLUTIONS;
//			}
//		}
//		ResolvedItem item = new ResolvedItem(resolution, domainClass, pattern, resolutions, dms.isDisabled(domainClass));
//		addLabels(item, domainClass, dms);
//		addRefLinks(item, domainClass, dms);
//		return item;
//	}
//
//	protected void addLabels(ResolvedItem typeItem, EClass type, DomainModelSource dms) {
//		if (!withLabels) {
//			return;
//		}
//		Resolution baseResolution = typeItem.getResolution() == null ? null : Resolution.LABEL; // exclude label if parent is excluded
//		Collection<EAttribute> resolvedAttrs = Collections.emptyList();
//		if (typeItem.getPattern() != null) {
//			resolvedAttrs = Arrays.asList(typeItem.getPattern().getLabels());
//		}
//		Resolution[] possibleResolutions = Arrays.equals(typeItem.getPossibleResolutions(), ResolvedItem.NO_RESOLUTIONS) ?
//				ResolvedItem.NO_RESOLUTIONS : ResolvedItem.LABEL_RESOLUTIONS; // exclude label if parent is excluded
//		for (EAttribute attribute : (List<? extends EAttribute>) type.getEAllAttributes()) {
//			Resolution resolution = resolvedAttrs.contains(attribute) ? baseResolution : null; // include only attributes resolved as labels
//			typeItem.addChild(new ResolvedItem(resolution, attribute, null, possibleResolutions, dms.isDisabled(attribute)));
//		}
//	}
//
//	protected void addRefLinks(ResolvedItem typeItem, EClass type, DomainModelSource dms) {
//		Resolution baseResolution = typeItem.getResolution() != Resolution.NODE ? null : Resolution.LINK; // ref links are available only for nodes
//		Collection<EReference> resolvedRefs = Collections.emptyList();
//		if (typeItem.getPattern() instanceof NodePattern) {
//			resolvedRefs = Arrays.asList(((NodePattern) typeItem.getPattern()).getRefLinks());
//		}
//		Resolution[] possibleResolutions = Arrays.equals(typeItem.getPossibleResolutions(), ResolvedItem.NO_RESOLUTIONS) ?
//				ResolvedItem.NO_RESOLUTIONS : ResolvedItem.LINK_RESOLUTIONS; // exclude link if parent is excluded
//		for (EReference reference : (List<? extends EReference>) type.getEAllReferences()) {
//			Resolution resolution = resolvedRefs.contains(reference) ? baseResolution : null; // include only refs resolved as links
//			typeItem.addChild(new ResolvedItem(resolution, reference, null, possibleResolutions, dms.isDisabled(reference)));
//		}
//	}
}
