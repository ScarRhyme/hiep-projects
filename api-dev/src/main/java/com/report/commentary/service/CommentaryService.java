package com.report.commentary.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.common.CommonUtil;
import com.data.common.Constants;
import com.data.common.Response;
import com.data.common.UttData;
import com.report.commentary.bo.CommentaryBO;
import com.report.commentary.dao.CommentaryDAO;
import com.report.commentary.form.CommentaryForm;


/**
 * @author TanPTN
 * @since May 3, 2019
 * @version 1.0
 */
@Service
public class CommentaryService {	
    @Autowired
    private CommentaryDAO cDAO;
    
    @Autowired
    private UttData uttData;

    public CommentaryBO findById(Long id) {
    	if (cDAO.findById(id).isPresent()) {
            return cDAO.findById(id).get();
    	} else {
    		return null;
    	}

    }
    

    @Transactional
    public void saveOrUpdate(CommentaryBO entity) {
        uttData.saveOrUpdate(entity);
        uttData.flushSession();
    }

    public void delete(CommentaryBO entity) {
        cDAO.delete(entity);
    }

    /**
     * Lấy ra comment bởi học kỳ và năm học
     * 
     * @param semester, year
     * @return
     */
    public CommentaryBO findComment(CommentaryForm form) {
        return cDAO.findComment(form.getUserId(), form.getSemester(), form.getYear(), uttData);
    }
}
