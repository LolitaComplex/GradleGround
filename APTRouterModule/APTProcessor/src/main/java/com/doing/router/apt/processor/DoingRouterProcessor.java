package com.doing.router.apt.processor;

import com.doing.router.apt.annotations.DoingRouter;

import java.util.Collections;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

public class DoingRouterProcessor extends AbstractProcessor {

    private static final String TAG = "DoingRouterProcessor";

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
        return false;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Collections.singleton(DoingRouter.class.getCanonicalName());
    }
}
