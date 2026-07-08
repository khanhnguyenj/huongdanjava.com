package com.huongdanjava.systemdesign.sagapattern.orderservice.web;

import com.huongdanjava.systemdesign.sagapattern.orderservice.web.dto.AddNewOrderResponse;
import com.huongdanjava.systemdesign.sagapattern.orderservice.web.dto.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import jakarta.annotation.Generated;

/**
 * A delegate to be called by the {@link OrdersApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-04T12:52:53.676943+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.23.0")
public interface OrdersApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /orders : Add a new order
     *
     * @param order  (optional)
     * @return Add new order successfully (status code 200)
     *         or Bad Request (status code 400)
     *         or Internal Server Error (status code 500)
     * @see OrdersApi#addNewOrder
     */
    default ResponseEntity<AddNewOrderResponse> addNewOrder(Order order) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"success\" : true, \"message\" : \"message\", \"data\" : { \"id\" : 1, \"code\" : 1234, \"name\" : \"Khanh\" } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"success\" : false, \"message\" : \"Required fields are missing\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"success\" : false, \"message\" : \"Required fields are missing\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
