package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Baseballteam;
import com.example.service.BaseballteamService;

/**
 * 球団情報を操作するコントローラー.
 * 
 * @author kairi.hashimoto
 *
 */
@Controller
@RequestMapping("/team")
public class BaseballteamController {

	@Autowired
	private BaseballteamService baseballteamService;

	/**
	 * 球団一覧を出力します.
	 * 
	 * @param model モデル
	 * @return 球団一覧画面
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {
		List<Baseballteam> baseballteamList = baseballteamService.showList();
		model.addAttribute("baseballteamList", baseballteamList);
		return "ex-1/list";
	}

	/**
	 * 球団詳細画面を出力します.
	 * 
	 * @param id    ID
	 * @param model モデル
	 * @return 球団詳細画面
	 */
	@RequestMapping("/detail")
	public String detail(Integer id, Model model) {
		Baseballteam baseballteam = baseballteamService.showDetail(id);
		model.addAttribute("baseballteam", baseballteam);
		return "ex-1/detail";
	}
}
