package com.housing.stay.service;

import java.util.List;

import com.housing.stay.dto.FeedBackDTO;
import com.housing.stay.exception.DuplicateRecordException;



public interface FeedBackServiceInt {

	public long add(FeedBackDTO dto) throws DuplicateRecordException;

	public void delete(FeedBackDTO dto);

	public FeedBackDTO findBypk(long pk);

	public FeedBackDTO findByIssue(String issue);

	public void update(FeedBackDTO dto) throws DuplicateRecordException;

	public List<FeedBackDTO> list();

	public List<FeedBackDTO> list(int pageNo, int pageSize);

	public List<FeedBackDTO> search(FeedBackDTO dto);

	public List<FeedBackDTO> search(FeedBackDTO dto, int pageNo, int pageSize);

	

}
