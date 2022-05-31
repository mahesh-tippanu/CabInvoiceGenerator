
import Cab_Generator.CabInvoiceGenerator;
import Cab_Generator.InvoiceSummary;
import Cab_Generator.Ride;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {
    CabInvoiceGenerator fare;

    @BeforeEach
    public void setUp() throws Exception {
        fare = new CabInvoiceGenerator();
    }

    @Test
    public void whenGivenDistanceAndTimeShouldReturnTotalFare() {
        Assertions.assertEquals(70, fare.calculateFare(5, 20), 0.000);
    }

    @Test
    public void whenGivenMultipleFaresShouldReturnAggregateTotalFare() {
        Ride[] ridesArray = {new Ride("1",2, 20),
                new Ride("1",4, 10),
                new Ride("2",10, 30)};
        Assertions.assertEquals(220, fare.calculateFareForMultipleRides(ridesArray), 0.0);
    }

    @Test
    public void givenDistanceAndTimeWhenAddedShouldReturnInvoiceSummary() {
        Ride[] rides = {
                new Ride("1",2, 5),
                new Ride("2",3, 5),
                new Ride("1",1, 1)
        };
        InvoiceSummary invoiceSummary = fare.invoiceSummaryCalculation(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 71);
        Assertions.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }

    @Test
    public void givenUserIdDistanceAndTimeShouldReturnInvoiceOfUser() {
        Ride[] rides = {
                new Ride("1",2, 5),
                new Ride("2",3, 5),
                new Ride("1",1, 1)
        };
        InvoiceSummary invoiceSummary = fare.listOfRidesOfUniqueUserId(rides,"1");
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 36);
        Assertions.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }
    }


