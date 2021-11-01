package com.doing.router.apt.processor;

import com.doing.router.apt.annotations.DoingRouter;
import com.google.auto.service.AutoService;

import java.util.Collections;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class DoingRouterProcessor extends AbstractProcessor {

    private static final String TAG = "DoingRouterProcessor";
    public static final String CLASS_NAME = DoingRouter.class.getCanonicalName();

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        System.out.println(TAG + " >>> process start ...");

        Set<Element> elements = (Set<Element>)
                roundEnvironment.getElementsAnnotatedWith(DoingRouter.class);

        System.out.println(TAG + " >>> all Annotation elements count = " +
            elements.size());

        if (elements.size() < 1) {
            return false;
        }

        for (Element element : elements) {
            final TypeElement typeElement = (TypeElement) element;

            final DoingRouter doingRouter = typeElement
                    .getAnnotation(DoingRouter.class);

            if (doingRouter == null) {
                return false;
            }

            String url = doingRouter.url();
            String description = doingRouter.description();
            String className = typeElement.getQualifiedName().toString();
            System.out.println(TAG + " >>> url = " + url);
            System.out.println(TAG + " >>> description = " + description);
            System.out.println(TAG + " >>> className = " + className);
        }

        System.out.println(TAG + " >>> process finish. ");
        return true;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        System.out.println(TAG + " >>> support type: " + DoingRouter.class.getCanonicalName());
        return Collections.singleton(DoingRouter.class.getCanonicalName());
    }

}
