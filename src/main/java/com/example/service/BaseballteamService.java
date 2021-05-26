package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Baseballteam;
import com.example.repository.BaseballteamRepository;

/**
 * 球団情報を操作するサービス.
 * 
 * @author kairi.hashimoto
 *
 */
@Service
@Transactional
public class BaseballteamService {

	@Autowired
	private BaseballteamRepository baseballteamRepository;

	/**
	 * 球団情報を全件取得します.
	 * 
	 * @return 球団情報一覧
	 */
	public List<Baseballteam> showList() {
		List<Baseballteam> baseballteamList = baseballteamRepository.findAll();
		return baseballteamList;
	}

	/**
	 * 球団情報を取得します.
	 * 
	 * @param id ID
	 * @return 球団情報
	 */
	public Baseballteam showDetail(Integer id) {
		return baseballteamRepository.load(id);
	}
}
