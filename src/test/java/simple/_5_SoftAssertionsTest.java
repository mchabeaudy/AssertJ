package simple;

import static character.Race.HOBBIT;

import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.InjectSoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class _5_SoftAssertionsTest extends TolkienTest {


    @Nested
    class BasicSoftAssertion {

        @Test
        void basicSoftAssertionsExample() {
            var softly = new SoftAssertions();

            softly.assertThat(frodo).as("Frodo").isEqualTo(sam);
            softly.assertThat(sauron.getRace()).isEqualTo(HOBBIT);
            softly.assertThat(gandalf.getAge()).isEqualTo(10);

            softly.assertAll();
        }
    }

    @Nested
    @ExtendWith(SoftAssertionsExtension.class)
    class JUnit5SoftAssertionExample1 {

        @InjectSoftAssertions
        SoftAssertions softly;

        @Test
        void soft_assertions_example() {
            softly.assertThat(frodo.getName()).isEqualTo("Pippin");
            softly.assertThat(sam.getName()).isEqualTo("Merry");

            // no need to call softly.assertAll(), this is done by the extension
        }

    }


    @Nested
    @ExtendWith(SoftAssertionsExtension.class)
    class JUnit5SoftAssertionExample2 {


        @Test
        void soft_assertions_example(SoftAssertions softly) {
            softly.assertThat(frodo.getName()).isEqualTo("Pippin");
            softly.assertThat(sam.getName()).isEqualTo("Merry");

            // no need to call softly.assertAll(), this is done by the extension
        }


        @ParameterizedTest
        @CsvSource({"1,1,2", "1,2,3", "21,15,36"})
        void parametrized_test_example(int a, int b, int sum, SoftAssertions softly) {
            // softly comes after parameters
            softly.assertThat(a + b).as("sum").isEqualTo(sum);
            softly.assertThat(a)
                    .isPositive()
                    .isLessThanOrEqualTo(sum);
        }
    }


}
