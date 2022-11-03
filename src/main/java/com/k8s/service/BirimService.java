package com.k8s.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
public class BirimService {

    private final BirimServiceImpl birim;
}
