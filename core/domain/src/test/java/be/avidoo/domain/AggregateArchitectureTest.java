package be.avidoo.domain;


import be.avidoo.domain.annotations.Aggregate;
import be.avidoo.domain.annotations.AggregateBuilder;
import be.avidoo.domain.dossier.DossierAggregate;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(
        packagesOf = {DossierAggregate.class},
        importOptions = ImportOption.DoNotIncludeTests.class)
public class AggregateArchitectureTest {

    @ArchTest
    public static ArchRule entityAndValueObjectVisibilityRule =
            classes()
                    .that().areNotAnnotatedWith(Aggregate.class)
                    .and().areNotAnnotatedWith(AggregateBuilder.class)
                    .should().bePackagePrivate();

    @ArchTest
    public static void aggregateAnnotationRules(JavaClasses importedClasses) {
        ArchRule namingToAnnotation = classes().that().haveSimpleNameEndingWith("Aggregate").should().beAnnotatedWith(Aggregate.class);
        namingToAnnotation.check(importedClasses);

        ArchRule annotationToNaming = classes().that().areAnnotatedWith(Aggregate.class).should().haveSimpleNameEndingWith("Aggregate");
        annotationToNaming.check(importedClasses);
    }
}
