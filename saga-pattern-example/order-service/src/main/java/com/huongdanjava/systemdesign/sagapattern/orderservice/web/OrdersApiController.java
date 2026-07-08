package com.huongdanjava.systemdesign.sagapattern.orderservice.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-04T12:39:15.929649+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.23.0")
@Controller
@RequestMapping("${openapi.orderService.base-path:/api}")
public class OrdersApiController implements OrdersApi {

    private final OrdersApiDelegate delegate;

    public OrdersApiController(@Autowired(required = false) OrdersApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new OrdersApiDelegate() {});
    }

    @Override
    public OrdersApiDelegate getDelegate() {
        return delegate;
    }

}
