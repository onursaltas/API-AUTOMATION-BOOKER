import apiClasses.*;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class testClass {

    WebDriver Webdriver;
    @Test
    public void T1_Create_Token() throws IOException {
        Create_Token createToken = new Create_Token(Webdriver);
        createToken.post_CreateToken_200_Test("createToken");
    }
    @Test
    public void T2_Get_BookingID()
    {
        GET_BookingID getBookingID = new GET_BookingID(Webdriver);
        getBookingID.get_BookingID_200_Test();
    }
    @Test
    public void T3_Get_BookingDetails()
    {
        GET_BookingDetails getBookingDetails = new GET_BookingDetails(Webdriver);
        getBookingDetails.get_BookingDetails_200_Test();
    }
    @Test
    public void T4_Create_Booking() throws IOException {
        CreateBooking createBooking = new CreateBooking(Webdriver);
        createBooking.post_CreateBooking_200_Test("createBooking");
    }
    @Test
    public void T5_Update_Booking() throws IOException {
        PUT_UpdateBooking updateBooking = new PUT_UpdateBooking(Webdriver);
        updateBooking.put_UpdateBooking_200_Test("updateBooking");
    }
    @Test
    public void T6_PartialUpdate_Booking() throws IOException {
        PATCH_Partial_UpdateBooking_ patchBooking = new PATCH_Partial_UpdateBooking_(Webdriver);
        patchBooking.patch_PartialUpdateBooking_Test("updateBooking");
    }
    @Test
    public void T7_Delete_Booking() throws IOException {
        DELETE_DeleteBooking deleteBooking = new DELETE_DeleteBooking(Webdriver);
        deleteBooking.delete_DeleteBooking_200_Test();
    }
}
