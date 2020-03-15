package com.report.averagescore.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.data.common.CommonUtil;
import com.data.common.Constants;
import com.data.common.DynamicExport;
import com.data.common.ExportUtils;
import com.data.common.Response;
import com.data.common.UttData;
import com.data.controller.BaseController;
import com.data.domain.DataTableResults;
import com.data.exception.SysException;
import com.data.exception.ValidateException;
import com.data.util.ImportUtils;
import com.report.averagescore.bean.AverageScoreBean;
import com.report.averagescore.bo.AverageScoreBO;
import com.report.averagescore.dao.AverageScoreDAO;
import com.report.averagescore.form.AverageScoreForm;
import com.report.averagescore.service.AverageScoreService;
import com.report.category.service.SysCatService;
import com.report.config.TemplateResouces;
import com.report.user.entity.PositionBO;
import com.report.user.entity.UserBO;
import com.report.user.service.JwtService;
import com.report.user.service.UserService;
/**
 * @author TanPTN
 * @since May 3, 2019
 * @version 1.0
 */	
@Controller
@RequestMapping("/utt-ess/average-scores")
public class AverageScoreController extends BaseController{

    private static String adResouceKey = "resource.commentary";
    @Autowired
    private AverageScoreService service;
    
    @Autowired
    private SysCatService scService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private AverageScoreDAO asDAO;
    
    @Autowired
    private UttData uttData;
    
    @Autowired
    private JwtService jwtService;
//    @Autowired
//    private PermissionChecker permissionChecker;

    @GetMapping(path = "/search")
    public @ResponseBody DataTableResults<AverageScoreBean> listStudents(HttpServletRequest req, AverageScoreForm form){
        return service.getDatatablesAS(form, req);
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Response findById(HttpServletRequest req, @PathVariable Long id) {
        AverageScoreBO bo = service.findById(id);
        if (bo == null) {
            return Response.warning(Constants.RESPONSE_CODE.RECORD_DELETED);
        }
        return Response.success().withData(bo);
    }

//    @GetMapping(path = "/search")
//    public @ResponseBody DataTableResults<CommentaryBO> getDatatables(HttpServletRequest req, CommentaryForm sysCatForm) {
//        return service.getDatatables(CommentaryForm, req);
//    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Response create(HttpServletRequest req, @RequestBody AverageScoreForm form) 
            throws Exception, SysException {
        Long averageScoreId = CommonUtil.NVL(form.getAverageScoreId());
        AverageScoreBO bo;
        if(averageScoreId > 0L) {
            bo = service.findById(averageScoreId);
            if(bo == null) {
                return Response.warning(Constants.RESPONSE_CODE.RECORD_DELETED);
            }
//            if (!permissionChecker.hasPermission("action.update", adResouceKey, req)) {
//                return Response.invalidPermission();
//            }
            bo.setModifiedDate(new Date());
            bo.setModifiedBy(jwtService.getUsernameFromToken(form.getToken()));
        } else {
            bo = new AverageScoreBO();
//            if (!permissionChecker.hasPermission("action.insert", adResouceKey, req)) {
//                return Response.invalidPermission();
//            }
            bo.setAverageScoreId(form.getAverageScoreId());
            bo.setCreatedDate(new Date());
            bo.setCreatedBy(jwtService.getUsernameFromToken(form.getToken()));
        }
        bo.setUserId(form.getUserId());
        bo.setScore(form.getScore());
        bo.setSemester(form.getSemester());
        bo.setYear(form.getYear());
        service.saveOrUpdate(bo);
        return Response.success(Constants.RESPONSE_CODE.SUCCESS).withData(bo);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Response delete(HttpServletRequest req,@PathVariable Long id) throws SysException, InstantiationException, IllegalAccessException {
        if(id > 0L) {
            AverageScoreBO bo = service.findById(id);
            if (bo != null) {
//                if (!permissionChecker.hasPermission("action.delete", adResouceKey, req)) {
//                    return Response.invalidPermission();
//                 }
                service.delete(bo);
                return Response.success(Constants.RESPONSE_CODE.DELETE_SUCCESS);
            } else {
                return Response.warning(Constants.RESPONSE_CODE.RECORD_DELETED);
            }
        } else {
            return Response.error(Constants.RESPONSE_CODE.ERROR);
        }
    }
    
    /**
     * Action Xu ly export du lieu
     *
     * @param form
     * @param resp
     * @param req
     * @param actionResult
     * @throws java.lang.Exception
     */
    @GetMapping(path = "/export")
    public ResponseEntity<InputStreamResource> actionProcessExportExcel(AverageScoreForm form, HttpServletRequest req) throws Exception {
//        if(! this.validateBeforeExport(frm, req, actionResult)) {
//            return;
//        }
        DynamicExport dynamicExport;
        dynamicExport = new DynamicExport(TemplateResouces.getReportFile("averageScore/BM_averageScore.xlsx", req), 0, true);
        
        DataTableResults<AverageScoreBean> result = service.getDatatablesAS(form, req);
        int startDataRow = 7;
        int numberOfColumns = 9;
        int stt = 0;
        ExportUtils exportUtils = new ExportUtils(dynamicExport, startDataRow, numberOfColumns);
        exportUtils.removeConfigRow(dynamicExport);
        
        Long positionId = CommonUtil.NVL(form.getPositionId());
        String deparmentName = service.getDeparmentName(positionId);
        dynamicExport.setEntry(deparmentName, 0 , 1);
        
        if (!CommonUtil.isNullOrEmpty(form.getSemester()) && !CommonUtil.isNullOrEmpty(form.getYear())) {
            String semester = scService.findByCode(form.getSemester());
            String year = scService.findByCode(form.getYear());
            dynamicExport.setEntry(semester + " / " + year, 0 , 4);
        }

        if(result != null) {
            List<AverageScoreBean> data = result.getData();
            int rowNumber = startDataRow;
            
            if (data.size() > 0) {
                for(AverageScoreBean bean: data) {
//                    exportUtils.exportRow(dynamicExport, bean, rowNumber);
                    dynamicExport.setEntry(String.valueOf(++stt),0 , rowNumber);
                    dynamicExport.setEntry(bean.getUserCode(),1 , rowNumber);
                    dynamicExport.setEntry(bean.getFullName(),2 , rowNumber);
                    if (bean.getGender().equals(1L)) {
                        dynamicExport.setEntry("Nam", 3, rowNumber);
                    } else if (bean.getGender().equals(2L)) {
                        dynamicExport.setEntry("Nữ", 3, rowNumber);
                    }
                    
                    dynamicExport.setEntry(bean.getDateOfBirth(),4 , rowNumber);
                    dynamicExport.setEntry(bean.getEmail(),5 , rowNumber);
                    dynamicExport.setEntry(bean.getMobileNumber(),6 , rowNumber);
                    dynamicExport.setEntry(bean.getClassName(),7 , rowNumber);
                    dynamicExport.setEntry(String.valueOf(bean.getScore()),8 , rowNumber);
                    rowNumber++;
                }
                dynamicExport.setCellFormat(startDataRow, 0, dynamicExport.getLastRow() + rowNumber, numberOfColumns - 1, DynamicExport.BORDER_FORMAT);
            }
            
        }
        String fileName = dynamicExport.exportFile("average_score", req);
        File file = new File(fileName);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        return ResponseEntity.ok()
                // Content-Disposition
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                // Content-Type
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                // Contet-Length
                .contentLength(file.length()) //
                .body(resource);
    }

    /**
     * Action Xu ly export du lieu
     *
     * @param form
     * @param resp
     * @param req
     * @param actionResult
     * @throws java.lang.Exception
     */
    @GetMapping(path = "/export-template")
    public ResponseEntity<InputStreamResource> actionProcessExportTemplateExcel(AverageScoreForm form, HttpServletRequest req) throws Exception {
//        if(! this.validateBeforeExport(frm, req, actionResult)) {
//            return;
//        }
        DynamicExport dynamicExport;
        dynamicExport = new DynamicExport(TemplateResouces.getImportFile("averageScore/Import_average_score.xls", req), 0, false);
        
        Long positionId = CommonUtil.NVL(form.getPositionId());
        //Danh sách sinh viên theo lớp
        List<UserBO> result = userService.getListStudentByPositionId(positionId);
        int startDataRow = 6;
        int numberOfColumns = 5;
        int stt = 0;
        ExportUtils exportUtils = new ExportUtils(dynamicExport, startDataRow, numberOfColumns);
        exportUtils.removeConfigRow(dynamicExport);
        
        // Lấy ra tên lớp
        PositionBO positionBO = userService.getClass(positionId);
        dynamicExport.setEntry(positionBO.getPositionName(), 3 , 2);
        
        if (!CommonUtil.isNullOrEmpty(form.getSemester()) && !CommonUtil.isNullOrEmpty(form.getYear())) {
            String semester = scService.findByCode(form.getSemester());
            String year = scService.findByCode(form.getYear());
            dynamicExport.setEntry(semester + " / " + year, 2 , 3);
        }

        if(result != null) {
            int rowNumber = startDataRow;
            
            if (result.size() > 0) {
                for(UserBO bo: result) {
//                    exportUtils.exportRow(dynamicExport, bean, rowNumber);
                    dynamicExport.setEntry(String.valueOf(++stt),0 , rowNumber);
                    dynamicExport.setEntry(bo.getUserCode(),1 , rowNumber);
                    dynamicExport.setEntry(bo.getFullName(),2 , rowNumber);
                    if (bo.getGender().equals(1L)) {
                        dynamicExport.setEntry("Nam", 3, rowNumber);
                    } else if (bo.getGender().equals(2L)) {
                        dynamicExport.setEntry("Nữ", 3, rowNumber);
                    }
                    
                    dynamicExport.setEntry(CommonUtil.convertDateToString(bo.getDateOfBirth()),4 , rowNumber);
                    rowNumber++;
                }
                dynamicExport.setCellFormat(startDataRow, 0, dynamicExport.getLastRow() + rowNumber, numberOfColumns, DynamicExport.BORDER_FORMAT);
            }
            
        }
        String fileName = dynamicExport.exportFile("BM_average_score", req);
        File file = new File(fileName);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        return ResponseEntity.ok()
                // Content-Disposition
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                // Content-Type
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                // Contet-Length
                .contentLength(file.length()) //
                .body(resource);
    }
    
    /**
     * Action Import AverageScore
     * @param req
     * @param form
     * @return
     * @throws Exception
     * @throws ValidateException 
     * @throws PermissionException 
     */
    @PostMapping(path = "/import", produces = javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Transactional
    public @ResponseBody Response processImport(HttpServletRequest req, AverageScoreForm frm) throws Exception, SysException {
        String cfgName = "averageScore/Import_average_score.cfg";
        ImportUtils importUtils = new ImportUtils(TemplateResouces.getImportFile(cfgName, req));
        
        String importFileName = "Import_average_score.xls";
        List<Object[]> dataList = new LinkedList<Object[]>();
        // validate cơ bản
        if (!importUtils.validateCommon(req, frm.getFileImport(), importFileName, dataList)) {
            return Response.warning("import.dataError").withData(importUtils.getErrorList());
        }
        if (dataList.size() == 1) {
            throw new ValidateException("Không có dữ liệu nhập vào");
        }
        
        List<AverageScoreBO> lstInsert = new ArrayList<AverageScoreBO>();
        int col;
        for (int row = 0; row < dataList.size(); row++) {
            Object[] objects = dataList.get(row);
            AverageScoreBO averageScoreBO = new AverageScoreBO();
            
            col = 1;
            String userCode = String.valueOf(objects[col]).trim();
            UserBO userBO = userService.getUserByCode(userCode);
            if (userBO == null) {
                importUtils.addError(row, col, "Mã sinh viên không tồn tại", userCode);
                continue;
            } else if (userBO.getPositionId() != frm.getPositionId()) {
                PositionBO positionBO = userService.getClass(frm.getPositionId());
                importUtils.addError(row, col, "Sinh viên này không thuộc lớp " + positionBO.getPositionName(), userCode);
                continue;
            } else if (validateUserExist(frm, userBO.getUserId())) {
                importUtils.addError(row, col, "Sinh viên đã tồn tại điểm TBTHT thuộc học kỳ" 
                                                + scService.findByCode(frm.getSemester())
                                                + " và năm học " + scService.findByCode(frm.getYear()), userCode);
                continue;
            } else {
                averageScoreBO.setUserId(userBO.getUserId());
            }
            
            averageScoreBO.setSemester(frm.getSemester());
            averageScoreBO.setYear(frm.getYear());
            
            col = 5;
            Double score = Double.valueOf(objects[col].toString());
            averageScoreBO.setScore(score);
            averageScoreBO.setCreatedBy(jwtService.getUsernameFromToken(frm.getToken()));
            averageScoreBO.setCreatedDate(new Date());
            lstInsert.add(averageScoreBO);
        }
        
        if (importUtils.hasError()) {
            return Response.warning("Dữ liệu bị lỗi").withData(importUtils.getErrorList());
        } else if (!lstInsert.isEmpty()) {
            for (AverageScoreBO newBO : lstInsert) {
                asDAO.save(newBO);
                uttData.flushSession();
                uttData.clear();
            }
//            asDAO.saveAll(lstInsert);
            return Response.success(Constants.RESPONSE_CODE.SUCCESS).withData(null);
        }
        return Response.success(Constants.RESPONSE_CODE.SUCCESS).withData(null);
    }
    
    public boolean validateUserExist(AverageScoreForm form, Long userId) {
        return service.validateUserExist(form, userId);
    }
    
    /**
     * statisticalEvaluate
     * @return
     */
    @GetMapping(path = "/statistical-average-score")
    public @ResponseBody Response statisticalAverageScore() {
        List<Long> lstScore = service.statisticalAverageScore();
        if (lstScore == null) {
            return Response.warning(Constants.RESPONSE_CODE.RECORD_DELETED);
        }

        return Response.success().withData(lstScore);
    }
}
