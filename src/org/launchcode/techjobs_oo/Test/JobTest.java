package org.launchcode.techjobs_oo.Test;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    private Job firstJob, secondJob, thirdJob;

    @Before
    public void createTestJobObjects(){
        firstJob = new Job();
        secondJob = new Job();
        thirdJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId(){
        //test that the Id values for the two objects are NOT the same and differ by 1.
        assertEquals(1, secondJob.getId()-firstJob.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertEquals("Product tester", thirdJob.getName());
        assertEquals("ACME", thirdJob.getEmployer().getValue());
        assertEquals("Desert", thirdJob.getLocation().getValue());
        assertEquals("Quality control", thirdJob.getPositionType().getValue());
        assertEquals("Persistence", thirdJob.getCoreCompetency().getValue());
    }


    @Test
    public void testJobsForEquality(){
        assertFalse(firstJob.equals(secondJob));
    }

    // Test Driven Development (TDD) : write tests for toString Method in Job Class
    //1. When passed a Job object, it should return a string that contains a blank line before and after the job information.
    //TODO: 1. Write test: when passed a Job object, it should return a string that contains a blank line before and after the job information

    @Test
    public void testToStringReturnsNewLine(){
        //get first character of string
        char firstCharacter = thirdJob.toString().charAt(0);
        //get last character
        char lastCharacter = thirdJob.toString().charAt(thirdJob.toString().length()-1);
        assertTrue(firstCharacter == lastCharacter);
    }

    //TODO: 2. Write test: The string should contain a label for each field, followed by the data stored in that field. Each field should be on its own line.

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        String output = String.format("\nID: %d\n" +
                        "Name: %s\n" +
                        "Employer: %s\n" +
                        "Location: %s\n" +
                        "Position Type: %s\n" +
                        "Core Competency: %s\n",thirdJob.getId(), thirdJob.getName(), thirdJob.getEmployer(), thirdJob.getLocation(),
                thirdJob.getPositionType(), thirdJob.getCoreCompetency());
        assertEquals(output, thirdJob.toString());
    }

    //TODO: 3. Write test: If a field is empty, the method should add, "Data no available" after the label.

    @Test
    public void testToStringHandlesEmptyField() {
        thirdJob.getEmployer().setValue("");
        thirdJob.getPositionType().setValue("");
        String output = String.format("\nID: %d\n" +
                "Name: %s\n" +
                "Employer: Data not available\n" +
                "Location: %s\n" +
                "Position Type: Data not available\n" +
                "Core Competency: %s\n",thirdJob.getId(), thirdJob.getName(), thirdJob.getLocation(), thirdJob.getCoreCompetency());
        assertEquals(output, thirdJob.toString());
    }
    //TODO: 4. (Bonus) If a Job object ONLY contains data for the id field, the method should return, "OOPS!" This job does not seem to exist."
}
