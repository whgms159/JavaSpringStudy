package com.kosta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import com.kosta.domain.PartiDTO;
import com.kosta.entity.Parti;
import com.kosta.entity.User;
import com.kosta.repository.PartiRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PartiServiceImpl implements PartiService{
	private final PartiRepository partiRepository;

	@Override
	public List<Parti> getAllParti() {
		
		return partiRepository.findAll();
	}

	@Override
	public void escapeParti(int id) {
		partiRepository.deleteById(id);
		
	}


	@Override
	public Parti findById(int id) throws Exception {
		Optional<Parti> partiId = partiRepository.findById(id);
		Parti parti = partiId.orElseThrow(() -> new Exception("오류겐"));
		return parti;
	}

	@Override
	public void save(Parti parti) {
		partiRepository.save(parti);
		
	}

	@Override
	public List<PartiDTO> getMyParti(User user) throws Exception {
		List<Parti> pList = partiRepository.findByMemberId(user.getId());
		return pList.stream().map(p -> PartiDTO.setPartiDTO(p)).toList();
		
	}

}
