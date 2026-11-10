package mn.edu.must.sqat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Лаб 9 — Хэсэг A: зөвхөн хэвийн (happy path) урсгалын тестүүд.
 * Хамралтыг хэмжих эхний цэг; алдааны болон зааг утгын замууд хараахан байхгүй.
 */
class ScholarshipCalculatorTest {

    private final ScholarshipCalculator calc = new ScholarshipCalculator();

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
}
