package com.akbulutmehmet.authservice.manager;

import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(url = "${web.service.url}", name = "webFeignClient", decode404 = true)
public interface IWebManager {

}
