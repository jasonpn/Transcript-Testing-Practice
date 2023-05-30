package test;

import model.Transcript;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class TranscriptTest {

    private Transcript testTranscript;

    @Before
    public void setUp(){
        testTranscript = new Transcript("Student Name", 1000);
        //TODO: write new values in testTranscript constructor
    }

    @Test
    public void testGetters(){
        assertEquals("Student Name", testTranscript.getStudentName());
        assertEquals(1000, testTranscript.getStudentID());

    }
    @Test
    public void testAddGrades(){
        assertEquals(0,testTranscript.getCourseGrades().size());
        testTranscript.addGrade("CPSC-210", 3.5);
        assertEquals(1,testTranscript.getCourseGrades().size());
        assertTrue(testTranscript.getCourseGrades().containsKey("CPSC-210"));
        assertTrue(testTranscript.getCourseGrades().containsValue(3.5));
        testTranscript.addGrade("ENGL-201", 4.0);
        assertEquals(2,testTranscript.getCourseGrades().size());
        assertTrue(testTranscript.getCourseGrades().containsKey("ENGL-201"));
        assertTrue(testTranscript.getCourseGrades().containsValue(4.0));

    }

    @Test
    public void testgetGPA(){
        assertEquals(0.0,testTranscript.getGPA(), 0.01);
        testTranscript.addGrade("CPSC-210", 3.5);
        assertEquals(3.5,testTranscript.getGPA(),0.01);
        testTranscript.addGrade("ENGL-201", 4.0);
        assertEquals((3.5+4.0)/2,testTranscript.getGPA(),0.001);
    }
}