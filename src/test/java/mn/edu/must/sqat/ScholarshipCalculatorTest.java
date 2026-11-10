package mn.edu.must.sqat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Лаб 9 — ScholarshipCalculator-ийн нэгжийн тестүүд.
 *
 * <p>Хэсэг A: зөвхөн хэвийн урсгал (5 тест).
 * Хэсэг B: алдааны зам, бүх switch салаа, &&/|| нөхцлийн бүх хослол (100% branch).
 * Хэсэг C: давталтын 0 / 1 / 2+ заагийн тестүүд.
 * Хэсэг D: зааг утгын тестүүд — 60 оноо "D" байх ёстойг шалгана.
 */
class ScholarshipCalculatorTest {

    private final ScholarshipCalculator calc = new ScholarshipCalculator();

    // ---------- Хэсэг A: happy path ----------

    @Test
    void letterGrade_95_returnsA() {
        assertEquals("A", calc.letterGrade(95));
    }

    @Test
    void letterGrade_85_returnsB() {
        assertEquals("B", calc.letterGrade(85));
    }

    @Test
    void gpa_95and85_returns3point5() {
        assertEquals(3.5, calc.gpa(new double[]{95, 85}), 1e-9);
    }

    @Test
    void scholarship_gpa3point9_16credits_noViolation_returns100() {
        assertEquals(100, calc.scholarship(3.9, 16, false));
    }

    @Test
    void scholarship_gpa3point5_13credits_noViolation_returns70() {
        assertEquals(70, calc.scholarship(3.5, 13, false));
    }

    // ---------- Хэсэг B: 100% branch / line ----------

    @Test
    void letterGrade_75_returnsC() {
        assertEquals("C", calc.letterGrade(75));
    }

    @Test
    void letterGrade_65_returnsD() {
        assertEquals("D", calc.letterGrade(65));
    }

    @Test
    void letterGrade_55_returnsF() {
        assertEquals("F", calc.letterGrade(55));
    }

    @Test
    void letterGrade_negative_throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(-1));
    }

    @Test
    void letterGrade_above100_throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(101));
    }

    @Test
    void gpa_allGradeCases_returns2point0() {
        // A=4, B=3, C=2, D=1, F=0 -> (4+3+2+1+0)/5 = 2.0
        assertEquals(2.0, calc.gpa(new double[]{95, 85, 75, 65, 55}), 1e-9);
    }

    @Test
    void gpa_null_throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.gpa(null));
    }

    @Test
    void gpa_empty_throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.gpa(new double[]{}));
    }

    @Test
    void scholarship_gpa3point2_10credits_noViolation_returns50() {
        assertEquals(50, calc.scholarship(3.2, 10, false));
    }

    @Test
    void scholarship_gpa2point9_10credits_noViolation_returns0() {
        assertEquals(0, calc.scholarship(2.9, 10, false));
    }

    @Test
    void scholarship_violation_returns0() {
        assertEquals(0, calc.scholarship(3.9, 16, true));
    }

    @Test
    void scholarship_gpa3point9_14credits_returns70() {
        // голч 100-ийн босгыг хангасан ч кредит 15-д хүрэхгүй -> 70
        assertEquals(70, calc.scholarship(3.9, 14, false));
    }

    @Test
    void scholarship_gpa3point5_11credits_returns50() {
        // голч 70-ийн босгыг хангасан ч кредит 12-д хүрэхгүй -> 50
        assertEquals(50, calc.scholarship(3.5, 11, false));
    }

    @Test
    void scholarship_negativeGpa_throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(-0.1, 10, false));
    }

    @Test
    void scholarship_gpaAbove4_throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(4.1, 10, false));
    }

    @Test
    void scholarship_negativeCredits_throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(3.5, -1, false));
    }
}
