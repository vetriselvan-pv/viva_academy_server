package com.viva.academy.auth.client;

import com.viva.academy.auth.dto.response.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "admin")
public interface AdminServiceClient {

    @GetMapping("/v1/branches/{branchId}")
    ApiResponse<Object> getBranchById(@PathVariable("branchId") String branchId);
}
