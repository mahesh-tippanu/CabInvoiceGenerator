
import Cab_Generator.CabInvoiceGenerator;
import Cab_Generator.InvoiceSummary;
import Cab_Generator.Ride;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {
        @Test
        public void givenDistanceAndTimeWhenAddedShouldReturnTotalFare() {
            CabInvoiceGenerator iG = new CabInvoiceGenerator();
            double distance = 2;
            int time = 5;
            double totalFare = iG.calculateFare(distance, time);
            Assertions.assertEquals(25, totalFare, 0.0);
        }
    @Test
    public void givenMultipleRide_ShouldReturnInvoiceSummary(){
        CabInvoiceGenerator invoiceGerator = new CabInvoiceGenerator();
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.11,1)
        };
        InvoiceSummary summary = invoiceGerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assertions.assertEquals(expectedInvoiceSummary,summary);
    }
    }

