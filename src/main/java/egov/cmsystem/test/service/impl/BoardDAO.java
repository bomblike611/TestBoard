package egov.cmsystem.test.service.impl;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("boardDAO")
public class BoardDAO extends EgovAbstractMapper{

	public final String namespace="egovframework.sqlmap.mappers.noticeMapper";
	
	public String selectOne()throws Exception{
		return getSqlSession().selectOne(namespace+".selectOne");
	}
	
}
