package seedu.address.model.animal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.AnimalBuilder;

public class NameContainsKeywordsPredicateAnimalTest {

    @Test
    public void equals() {
        List<String> firstPredicateKeywordList = Collections.singletonList("first");
        List<String> secondPredicateKeywordList = Arrays.asList("first", "second");

        NameContainsKeywordsPredicateAnimal firstPredicate =
                new NameContainsKeywordsPredicateAnimal(firstPredicateKeywordList);
        NameContainsKeywordsPredicateAnimal secondPredicate =
                new NameContainsKeywordsPredicateAnimal(secondPredicateKeywordList);

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        NameContainsKeywordsPredicateAnimal firstPredicateCopy =
                new NameContainsKeywordsPredicateAnimal(firstPredicateKeywordList);
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different animal -> returns false
        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_nameContainsKeywords_returnsTrue() {
        // One keyword
        NameContainsKeywordsPredicateAnimal predicate =
                new NameContainsKeywordsPredicateAnimal(Collections.singletonList("Whiskers"));
        assertTrue(predicate.test(new AnimalBuilder().withName("Whiskers Cat").build()));

        // Multiple keywords
        predicate = new NameContainsKeywordsPredicateAnimal(Arrays.asList("Whiskers", "Luna"));
        assertTrue(predicate.test(new AnimalBuilder().withName("Whiskers Luna").build()));

        // Only one matching keyword
        predicate = new NameContainsKeywordsPredicateAnimal(Arrays.asList("Luna", "Simba"));
        assertTrue(predicate.test(new AnimalBuilder().withName("Whiskers Simba").build()));

        // Mixed-case keywords
        predicate = new NameContainsKeywordsPredicateAnimal(Arrays.asList("wHISkers", "lUNA"));
        assertTrue(predicate.test(new AnimalBuilder().withName("Whiskers Luna").build()));
    }

    @Test
    public void test_nameDoesNotContainKeywords_returnsFalse() {
        // Zero keywords
        NameContainsKeywordsPredicateAnimal predicate =
                new NameContainsKeywordsPredicateAnimal(Collections.emptyList());
        assertFalse(predicate.test(new AnimalBuilder().withName("Whiskers").build()));

        // Non-matching keyword
        predicate = new NameContainsKeywordsPredicateAnimal(Arrays.asList("Fluffy"));
        assertFalse(predicate.test(new AnimalBuilder().withName("Whiskers Luna").build()));

        // Keywords match description and location, but does not match name
        predicate = new NameContainsKeywordsPredicateAnimal(
                Arrays.asList("playful", "tabby", "Shelter", "Room"));
        assertFalse(predicate.test(new AnimalBuilder().withName("Whiskers")
                .withDescription("A playful tabby cat")
                .withLocation("Shelter Room 2").build()));
    }

    @Test
    public void toStringMethod() {
        List<String> keywords = List.of("keyword1", "keyword2");
        NameContainsKeywordsPredicateAnimal predicate =
                new NameContainsKeywordsPredicateAnimal(keywords);

        String expected = NameContainsKeywordsPredicateAnimal.class.getCanonicalName()
                + "{keywords=" + keywords + "}";
        assertEquals(expected, predicate.toString());
    }
}
