package com.adopcion.serviceimpl;

import com.adopcion.dao.SubsRepository;
import com.adopcion.domain.Subs;
import com.adopcion.service.SubsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubsServiceImpl implements SubsService {

    @Autowired
    private SubsRepository subsRepository;

    @Override
    public Subs createSubs(Subs subs) {
        return subsRepository.save(subs);
    }

    @Override
    public List<Subs> getSubsHistory() {
        return subsRepository.findAll();
    }
    @Override
    public Subs updateSubsStatus(Long id, String status) {
        Subs subs = subsRepository.findById(id).orElseThrow(() -> new RuntimeException("Suscripción no encontrada"));
        subs.setStatus(status);
        return subsRepository.save(subs);
    }
}