package com.geniisys.tdd.automation.underwriting.maintenance.intermediary.intermediary.giiss076;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.geniisys.tdd.automation.common.DatePicker;
import com.geniisys.tdd.automation.common.BrowserDriver;
import com.geniisys.tdd.automation.common.MessageOverlay;
import com.geniisys.tdd.automation.common.ModalDialog;

public class GIISS076Page {
	
	private static final Logger LOGGER = LogManager.getLogger(GIISS076Page.class);
	
	private BrowserDriver driver;
	private DatePicker datePicker;
	private MessageOverlay messageOverlay;
	private ModalDialog modalDialog;
	
	private final By homeBtnLocator = By.id("footerHome");
	
	// Field elements
	private final By refIntmCdTxtLocator = By.id("refIntmCd");
	private final By caNoTxtLocator = By.id("caNo");
	private final By caDateImgLocator = By.id("imgCaDate");
	
	private final By designationTxtLocator = By.id("designation");
	private final By intmNameTxtLocator = By.id("intmName");
	
	private final By parentIntmNoImgLocator = By.id("searchParentIntmNoLOV");
	
	private final By contactPersonTxtLocator = By.id("contactPerson");
	private final By phoneNoTxtLocator = By.id("phoneNo");
	
	private final By issCdTxtLocator = By.id("issCd");
	private final By issCdImgLocator = By.id("searchIssCdLOV");
	private final By oldIntmNoTxtLocator = By.id("oldIntmNo");
	
	private final By whtaxCdTxtLocator = By.id("whtaxCode");
	private final By whtaxCdImgLocator = By.id("searchWhtaxCodeLOV");
	
	private final By intmTypeTxtLocator = By.id("intmType");
	private final By intmTypeImgLocator = By.id("searchIntmTypeLOV");
	private final By tinTxtLocator = By.id("tin");
	
	private final By coIntmTypeTxtLocator = By.id("coIntmType");
	private final By coIntmTypeImgLocator = By.id("searchCoIntmTypeLOV");
	
	private final By paytTermsTxtLocator = By.id("paytTerms");
	private final By paytTermsImgLocator = By.id("searchPaytTermsLOV");
	private final By birthdateImgLocator = By.id("imgBirthdate");
	
	private final By mailAddr1TxtLocator = By.id("mailAddr1");
	private final By mailAddr2TxtLocator = By.id("mailAddr2");
	private final By mailAddr3TxtLocator = By.id("mailAddr3");
	
	private final By billAddr1TxtLocator = By.id("billAddr1");
	private final By billAddr2TxtLocator = By.id("billAddr2");
	private final By billAddr3TxtLocator = By.id("billAddr3");
	
	private final By emailAddrTxtLocator = By.id("emailAddr");
	
	private final By parentIntmTinTxtLocator = By.id("prntIntmTinSw");
	private final By specialRateTxtLocator = By.id("specialRate");
	private final By lfTagTxtLocator = By.id("lfTag");
	private final By corpTagTxtLocator = By.id("corpTag");
	private final By activeTagTxtLocator = By.id("activeTag");
	private final By licTagTxtLocator = By.id("licTag");
	private final By inputVatRateTxtLocator = By.id("inputVatRate");
	private final By historyImgLocator = By.id("btnHistory");
	
	private final By remarksTxtLocator = By.id("remarks");
	
	private final By deleteBtnLocator = By.id("btnDelete");
	
	private final By copyIntmBtnLocator = By.id("btnCopyIntm");
	private final By additionalInfoBtnLocator = By.id("btnAdditionalInfo");
	private final By masterIntmDetailsBtnLocator = By.id("btnMasterIntmDetails");
	private final By cancelBtnLocator = By.id("btnCancel");
	private final By saveBtnLocator = By.id("btnSave");
	
	public GIISS076Page delete() {
		driver.findClickableElement(deleteBtnLocator).click();
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page copy() {
		driver.findClickableElement(copyIntmBtnLocator).click();
		
		if(messageOverlay.getMessageType().contains("INFORMATION")) {
			LOGGER.info("Message prompt displayed.");
			messageOverlay.clickOk();
		}
		
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page openAdditionalInfo() {
		driver.findClickableElement(additionalInfoBtnLocator).click();
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page closeAdditionalInfo() {
		modalDialog.exitModal();
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page checkMasterIntmDetails() {
		driver.findClickableElement(masterIntmDetailsBtnLocator).click();
		modalDialog.exitModal();
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page cancel() {
		driver.findClickableElement(cancelBtnLocator).click();
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page save() {
		driver.findClickableElement(saveBtnLocator).click();
		
		if(messageOverlay.getMessageType().contains("SUCCESS") ||
		   messageOverlay.getMessageType().contains("INFORMATION")) {
			LOGGER.info("Message prompt displayed.");
			messageOverlay.clickOk();
		}
		
		return new GIISS076Page(driver);
	}
	
	
	
	
	
	public GIISS076Page(BrowserDriver driver) {
		this.driver = driver;
		this.datePicker = new DatePicker(driver);
		this.messageOverlay = new MessageOverlay(driver);
		this.modalDialog = new ModalDialog(driver);
	}
	
	public GIISS076Page goToHome() {
		driver.findElement(homeBtnLocator).click();
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page setRefIntmCode(String refCd) {
		driver.findElement(refIntmCdTxtLocator).clear();
		driver.findElement(refIntmCdTxtLocator).sendKeys(refCd);
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page setCANo(String caNo) {
		driver.findElement(caNoTxtLocator).clear();
		driver.findElement(caNoTxtLocator).sendKeys(caNo);
		return new GIISS076Page(driver);
	}
	
	// Sample date format ["Jan-01-2018" or "Jan/01/2018/"] day should be two digit
	public GIISS076Page setCADate(String date) {
		datePicker.setDate(caDateImgLocator, date);
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page setIntmDesignation(String designation) {
		driver.findElement(designationTxtLocator).clear();
		driver.findElement(designationTxtLocator).sendKeys(designation);
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page setIntmName(String intmName) {
		driver.findElement(intmNameTxtLocator).clear();
		driver.findElement(intmNameTxtLocator).sendKeys(intmName, Keys.ENTER);
		
		if(messageOverlay.getMessageType().contains("INFORMATION")) {
			LOGGER.info("Message prompt displayed.");
			messageOverlay.clickOk();
		}
		
		return new GIISS076Page(driver);
	}
	
	public String getIntmName() {
		return driver.findElement(intmNameTxtLocator).getAttribute("value");
	}
	
	public GIISS076Page clearIntmName() {
		driver.findElement(intmNameTxtLocator).clear();
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page setParentIntmNo(String keyword) {
		driver.findClickableElement(parentIntmNoImgLocator).click();
		modalDialog.searchAndSelect(keyword);
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page setContactPerson(String contactPerson) {
		driver.findElement(contactPersonTxtLocator).clear();
		driver.findElement(contactPersonTxtLocator).sendKeys(contactPerson);
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page setContactNo(String contactNo) {
		driver.findElement(phoneNoTxtLocator).clear();
		driver.findElement(phoneNoTxtLocator).sendKeys(contactNo);
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page setIssSource(String keyword) {
		driver.findElement(issCdImgLocator).click();
		modalDialog.searchAndSelect(keyword);
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page clearIssSource() {
		driver.findElement(issCdTxtLocator).clear();
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page setOldIntmNo(String oldIntmNo) {
		driver.findElement(oldIntmNoTxtLocator).clear();
		driver.findElement(oldIntmNoTxtLocator).sendKeys(oldIntmNo);
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page setWhtaxCd(String keyword) {
		driver.findElement(whtaxCdImgLocator).click();
		modalDialog.searchAndSelect(keyword);
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page clearWhtaxCd() {
		driver.findElement(whtaxCdTxtLocator).clear();
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page setIntmType(String keyword) {
		driver.findElement(intmTypeImgLocator).click();
		modalDialog.searchAndSelect(keyword);
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page clearIntmType() {
		driver.findElement(intmTypeTxtLocator).clear();
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page setTin(String tin) {
		driver.findElement(tinTxtLocator).clear();
		driver.findElement(tinTxtLocator).sendKeys(tin);
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page clearTin() {
		driver.findElement(tinTxtLocator).clear();
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page setCoIntmType(String keyword) {
		driver.findElement(coIntmTypeImgLocator).click();
		modalDialog.searchAndSelect(keyword);
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page clearCoIntmType() {
		driver.findElement(coIntmTypeTxtLocator).clear();
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page setPaytTerms(String keyword) {
		driver.findElement(paytTermsImgLocator).click();
		modalDialog.searchAndSelect(keyword);
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page clearPaytTerms() {
		driver.findElement(paytTermsTxtLocator).clear();
		return new GIISS076Page(driver);
	}
	
	// Sample date format ["Jan-01-2018" or "Jan/01/2018/"] day should be two digit
	public GIISS076Page setBirthdate(String date) {
		datePicker.setDate(birthdateImgLocator, date);
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page setMailAddr1(String mailAddr) {
		driver.findElement(mailAddr1TxtLocator).clear();
		driver.findElement(mailAddr1TxtLocator).sendKeys(mailAddr);
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page clearMailAddr1() {
		driver.findElement(mailAddr1TxtLocator).clear();
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page setMailAddr2(String mailAddr) {
		driver.findElement(mailAddr2TxtLocator).clear();
		driver.findElement(mailAddr2TxtLocator).sendKeys(mailAddr);
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page setMailAddr3(String mailAddr) {
		driver.findElement(mailAddr3TxtLocator).clear();
		driver.findElement(mailAddr3TxtLocator).sendKeys(mailAddr);
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page setBillAddr1(String billAddr) {
		driver.findElement(billAddr1TxtLocator).clear();
		driver.findElement(billAddr1TxtLocator).sendKeys(billAddr);
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page setBillAddr2(String billAddr) {
		driver.findElement(billAddr2TxtLocator).clear();
		driver.findElement(billAddr2TxtLocator).sendKeys(billAddr);
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page setBillAddr3(String billAddr) {
		driver.findElement(billAddr3TxtLocator).clear();
		driver.findElement(billAddr3TxtLocator).sendKeys(billAddr);
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page setEmailAddr(String emailAddr) {
		driver.findElement(emailAddrTxtLocator).clear();
		driver.findElement(emailAddrTxtLocator).sendKeys(emailAddr);
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page clearEmailAddr() {
		driver.findElement(emailAddrTxtLocator).clear();
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page setParentIntmTin(String parentIntmTin) {
		driver.findElement(parentIntmTinTxtLocator).clear();
		driver.findElement(parentIntmTinTxtLocator).sendKeys(parentIntmTin);
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page clearParentIntmTin() {
		driver.findElement(parentIntmTinTxtLocator).clear();
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page setSpecialRate(String specialRate) {
		driver.findElement(specialRateTxtLocator).clear();
		driver.findElement(specialRateTxtLocator).sendKeys(specialRate);
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page clearSpecialRate() {
		driver.findElement(specialRateTxtLocator).clear();
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page setLFTag(String lfTag) {
		driver.findElement(lfTagTxtLocator).clear();
		driver.findElement(lfTagTxtLocator).sendKeys(lfTag);
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page setCorpTag(String corpTag) {
		driver.findElement(corpTagTxtLocator).clear();
		driver.findElement(corpTagTxtLocator).sendKeys(corpTag);
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page clearCorpTag() {
		driver.findElement(corpTagTxtLocator).clear();
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page setActiveTag(String activeTag) {
		driver.findElement(activeTagTxtLocator).clear();
		driver.findElement(activeTagTxtLocator).sendKeys(activeTag);
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page clearActiveTag() {
		driver.findElement(activeTagTxtLocator).clear();
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page setLicTag(String licTag) {
		driver.findElement(licTagTxtLocator).clear();
		driver.findElement(licTagTxtLocator).sendKeys(licTag);
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page clearLicTag() {
		driver.findElement(licTagTxtLocator).clear();
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page setInputVatRate(String vatRate) {
		driver.findElement(inputVatRateTxtLocator).clear();
		driver.findElement(inputVatRateTxtLocator).sendKeys(vatRate);
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page clearInputVatRate() {
		driver.findElement(inputVatRateTxtLocator).clear();
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page checkIntmHistory() {
		driver.findClickableElement(historyImgLocator).click();
		modalDialog.exitModal();
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page setRemarks(String remarks) {
		driver.findElement(remarksTxtLocator).clear();
		driver.findElement(remarksTxtLocator).sendKeys(remarks);
		return new GIISS076Page(driver);
	}
	
}
