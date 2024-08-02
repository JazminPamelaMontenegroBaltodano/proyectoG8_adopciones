package com.adopcion.service;

import com.adopcion.domain.Subs;

import java.util.List;

public interface SubsService {
    Subs createSubs(Subs subs);
    List<Subs> getSubsHistory();
    Subs updateSubsStatus(Long id, String status);
}