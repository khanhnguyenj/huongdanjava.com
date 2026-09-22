package com.huongdanjava.systemdesign.sagapattern.orderservice.client;

import com.huongdanjava.systemdesign.sagapattern.web.dto.StockReleaseRequest;
import com.huongdanjava.systemdesign.sagapattern.web.dto.StockReservationRequest;
import com.huongdanjava.systemdesign.sagapattern.web.dto.StockReservationResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange("/api")
public interface StockClient {

   @PostExchange("/stock-reservations")
   StockReservationResponse reserve(@RequestBody StockReservationRequest request);

   @PostExchange("/stock-reservations/release")
   void release(@RequestBody StockReleaseRequest request);
}
