package com.se.example.footballtournamentmanagment.repository;

import com.se.example.footballtournamentmanagment.entity.PlayerAmplua;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TourmanentGroupRepository extends PagingAndSortingRepository<PlayerAmplua, Long> {
}
