/**
 * Copyright (C) 2012, Xieda Technology, Inc.
 */
package com.jy.qrcodemake.util;

/**
 * Define all constants of jmcdc.
 * 
 * @author frank
 * @since 04.05.2012
 */
public final class Constants {

	/**
	 * An explicit private constructor to prevent creating an instance for this class.
	 */
    private Constants() {
		
	}
	/**
	 * Constants related to Test form
	 * 
	 */
    public static final Integer PRODUCT_TEST_FORM = 0;
    public static final Integer SCENE_TEST_FORM = 1;
    public static final Integer HOSPITAL_TEST_FORM = 2;
    public static final Integer OCCUPATION_TEST_FORM = 3;
    public static final Integer RADIOLOGICAL_TEST_FORM = 4;
    public static final Integer DISEASE_TEST_FORM = 5;
    public static final Integer TSGS = 6;
    
    
    /*
     * Constants related to UserVO module.
     */ 
    public static final String URL_VIEW_USERS = "viewUsers.do";
    public static final String URL_ADD_USER = "addUser.do";
    public static final String URL_CHANGEOWNPASSWORD = "changeOwnPassword.do";
    public static final String URL_DELETE_USER_SUCCESS = "deleteUserSuccess.do";
    
    public static final String URL_VIEW_USER = "viewUser.do";
    public static final String URL_RESETPASSWORD = "resetUserPassword.do";
    public static final String URL_UPDATE_ADMINSTATUS = "updateAdminStatus.do";
    public static final String URL_DELETE_USER = "deleteUser.do";

    public static final int USERNAME_MAXLENGTH = 64;
    public static final int USERNAME_MINLENGTH = 3;
    public static final int PASSWORD_MAXLENGTH = 64;
    public static final int PASSWORD_MINLENGTH = 3; 
    
    /**
     * ϵͳ���н�ɫ���塣
     * */
    //�Һ���Ա
    public static final String ROLE_REGIST_OPERATE = "role_regist_operate";

    
    //ҽ�ƹ���
    public static final String ROLE_MEDICAL_DOCTOR ="role_medical_doctor";
    public static final String ROLE_MEDICAL_TEST ="role_medical_test";
    public static final String ROLE_MEDICAL_RECORD ="role_medical_record";
    public static final String ROLE_MEDICAL_MANAGEMENT ="role_medical_management";
    public static final String ROLE_MEDICAL_FREEDRUG ="role_medical_freeDrug";
    public static final String ROLE_MEDICAL_NURSE ="role_medical_nurse";
    
    
    //���߹滮����
    public static final String ROLE_IMMUNITY_BOOK = "role_immunity_book";
    public static final String ROLE_IMMUNITY_VACCINATE = "role_immunity_vaccinate";
    public static final String ROLE_IMMUNITY_PLAN = "role_immunity_plan";
    
    
    //ҩƷ����
    public static final String ROLE_FINANCIAL_DRUG = "role_financial_drug";
    public static final String ROLE_DEPT_DRUG = "role_dept_drug";
    
    //ϵͳ�����Ȩ��
    //ҩƷ����
    public static final String ROLE_FINANCIAL_DRUGAPPROVE = "role_financial_drugApprove";
    //���ʲ��ϱ���
    public static final String ROLE_FINANCIAL_MATERIALAPPROVE = "role_financial_materialApprove";
    //��׼Ʒ����
    public static final String ROLE_FINANCIAL_STANDARDAPPROVE = "role_financial_standardApprove";
    
    
    //�û�Ȩ�޹���
    public static final String ROLE_SYSTEM_ADMIN = "role_system_admin";
    
    //���������Ԥ��
    public static final String ROLE_EPIDEMIC_ANALYSE = "role_epidemic_analyse";
    
    
    //�ۺ��շѹ���
    public static final String ROLE_FINANCIAL_CHARGE = "role_financial_charge";
    
    
    //����Ӧ��
    //����Ӧ���칫��-12320��ѯ���������
    public static final String ROLE_EMERGENCY_CALL = "role_emergency_call";
    //����Ӧ���칫��-����Ӧ���ۺ�Э��
    public static final String ROLE_EMERGENCY_DUTY = "role_emergency_duty";
    //����Ӧ���칫��-����Ӧ���滮����ѵ
    public static final String ROLE_EMERGENCY_TRAIN = "role_emergency_train";

    
    //������
    //����-���Բ��˺���������������
    public static final String ROLE_CHRONIC_DEATH = "role_chronic_death";
    
    //�����
    //����-�����
    public static final String ROLE_CHRONIC_YCCHRONIC = "role_chronic_ycchronic";
    //����-������ϱ�
    public static final String ROLE_CHRONIC_REPORT = "role_chronic_report";
   
    
    //����Ѫ�ܼ�������
    public static final String ROLE_CHRONIC_HEARTBRAIN = "role_chronic_heartbrain"; 
    //����Ѫ�ܼ����ϱ�
    public static final String ROLE_CHRONIC_HEARTBRAINREPORT = "role_chronic_heartbrainreport"; 
    
    //�����Ǽǹ���
    public static final String ROLE_CHRONIC_CANCER = "role_chronic_cancer"; 
    //�����Ǽ�
    public static final String ROLE_CHRONIC_CANCERREPORT = "role_chronic_cancerreport"; 
    
    //�ɹ�����
    //�ƻ������-������
    public static final String ROLE_FINANCIAL_COST = "role_financial_cost";
    //�����-�ɹ�
    public static final String ROLE_GENERAL_PURCHASE ="role_general_purchase";
    
    
    //���µ�������
    //�칫��-������Դ����
    public static final String ROLE_OFFICE_HUMAN ="role_office_human";

    
    //���ʹ���
    //�칫��-н�����
    public static final String ROLE_OFFICE_SALARY ="role_office_salary";
    
    
    //�������
    //�ƻ������-����
    public static final String ROLE_FINANCIAL_CASH ="role_financial_cash";
    //�����-ά��
    public static final String ROLE_GENERAL_MAINT ="role_general_maint";
    
    
    //���ڹ���
    //�칫��-����
    public static final String ROLE_OFFICE_ATTEND ="role_office_attend";
    
    
    //ʵ����
    //��Ʒ����
    //ʵ����-��������
    public static final String ROLE_LAB_ACCEPT ="role_lab_accept";
    //ʵ����-�������
    public static final String ROLE_LAB_TASK ="role_lab_task";
    //ʵ����-ԭʼ��¼У��
    public static final String ROLE_LAB_CHECK ="role_lab_check";
    //ʵ����-�������
    public static final String ROLE_LAB_REPORTEDIT ="role_lab_reportedit";
    //ʵ����-�������
    public static final String ROLE_LAB_REVIEW ="role_lab_review";
    //ʵ����-��Ȩǩ��
    public static final String ROLE_LAB_SIGN ="role_lab_sign";
    //ʵ����-�������
    public static final String ROLE_LAB_FLOW ="role_lab_flow";
    //ʵ����-Ͷ�ߴ���
    public static final String ROLE_LAB_COMPLAINT ="role_lab_complaint";
    
    
    //�����豸����
    //ʵ����-�豸����
    public static final String ROLE_LAB_DEVICE ="role_lab_device";
    
    
    //��׼Ʒ����
    //ʵ����-��׼Ʒ����
    public static final String ROLE_LAB_STANDARD ="role_lab_standard";
    
    
    //������ϵ����
    //ʵ����-��������
    public static final String ROLE_LAB_QUALITY ="role_lab_quality";
    
    
    //ʵ����-����Ա
    public static final String ROLE_LAB_ADMIN ="role_lab_admin";
    
    
    //����֢״���������Ԥ��
    //����Ӧ���칫��-����֢״�ϱ�
    public static final String ROLE_SYMPTOM_REPORT ="role_symptom_report";
    //�����Ѿ��칫��-����֢״Ԥ�����
    public static final String ROLE_SYMPTOM_MONITOR ="role_symptom_monitor";
    
    
    //���в�ѧ�������
    //����Ӧ���칫��-�ֳ����в�ѧ�������
    public static final String ROLE_EMERGENCY_EPIDEMIC ="role_emergency_epidemic";
    
    
    //����ѧϰ�뿼��
    //����ѧϰ�뿼��
    public static final String ROLE_STUDY_NORMAL ="role_study_normal";
    //����ѧϰ�뿼�Թ���
    public static final String ROLE_STUDY_MANAGER ="role_study_manager";
    
    
    //��֧����
    //�ƻ������-��֧����
    public static final String ROLE_FINANCIAL_BALANCE ="role_financial_balance";
    
    
    //��Ч����
    //�칫��-��Ч����
    public static final String ROLE_OFFICE_KPI ="role_office_kpi";
    
    
    
    //�������
    //�������-ְҵ�������
    public static final String ROLE_PHYSICAL_OCCUPATION ="role_physical_occupation";
    //�������-��ҵ�������
    public static final String ROLE_PHYSICAL_EMPLOY ="role_physical_employ";
    //��ҵ���-�������    
    public static final String  ROLE_SIGN_CHECK ="role_sign_check";
    //��ҵ���-X�߼��
   public static final String ROLE_XRAY_CHECK ="role_xray_check";
    //��ҵ���-ʵ���Ҽ�� 
    public static final String ROLE_PHYSICAL_LAB ="role_physical_lab";
    
    //�������-�������
    public static final String ROLE_PHYSICAL_NORMAL ="role_physical_normal";
    //�������-ѧ�����
    public static final String ROLE_PHYSICAL_STUDENT ="role_physical_student";
    //�������-����ҽ��
    public static final String ROLE_PHYSICAL_DOCTOR ="role_physical_doctor";
    
    
    //ְҵ�����
    //ְҵ��������-ְҵ���������
    public static final String ROLE_OCCUPATION_ACCEPT ="role_occupation_accept";
    //ְҵ��������-ְҵ������������
    public static final String ROLE_OCCUPATION_REVIEW ="role_occupation_review";
    //ְҵ��������-ְҵ�����ҽʦ��ȡ
    public static final String ROLE_OCCUPATION_EXTRACT ="role_occupation_extract";
    //ְҵ��������-ְҵ�����ҽʦ
    public static final String ROLE_OCCUPATION_DOCTOR ="role_occupation_doctor";
    //ְҵ��������-ְҵ����Ͻ�����
    public static final String ROLE_OCCUPATION_RESULTREVIEW ="role_occupation_resultreview";
    //ְҵ��������-ְҵ�����֤���鷢��
    public static final String ROLE_OCCUPATION_ISSUE ="role_occupation_issue";
    //ְҵ��������-ְҵ����Ϲ���
    public static final String ROLE_OCCUPATION_ALL ="role_occupation_all";
    
    
    //�������Ա����
    //�칫��-����Ա
    public static final String ROLE_OFFICE_ADMIN ="role_office_admin";
    //�����-����Ա
    public static final String ROLE_UNION_ADMIN="role_union_admin";
    //����ƹ���Ա
    public static final String ROLE_FINANCIAL_ADMIN = "role_financial_admin";
    //�ƽ����������-����Ա
    public static final String ROLE_QUALITY_ADMIN ="role_quality_admin";
    //���Դ�Ⱦ�����������Ա
    public static final String ROLE_EPIDEMIC_ADMIN = "role_epidemic_admin";
    //����Ӧ���칫��-����Ա
    public static final String ROLE_EMERGENCY_ADMIN = "role_emergency_admin";
    //���벡ý���������-����Ա
    public static final String ROLE_VECTOR_ADMIN = "role_vector_admin";
    //Ѫ��没������-����Ա
    public static final String ROLE_SCHISTOSOMIASIS_ADMIN = "role_schistosomiasis_admin";
    //�Բ����̲����ƿ�-����Ա
    public static final String ROLE_AIDS_ADMIN = "role_aids_admin";
    //��������Ա
    public static final String ROLE_MEDICAL_ADMIN = "role_medical_admin";
    //����-����Ա
    public static final String ROLE_CHRONIC_ADMIN = "role_chronic_admin";
    //���߹滮�ƹ���Ա
    public static final String ROLE_IMMUNITY_ADMIN = "role_immunity_admin";
    //��Ϣ��-����Ա
    public static final String ROLE_INFORMATION_ADMIN = "role_information_admin";
    //�����������-����Ա
    public static final String ROLE_CHECK_ADMIN ="role_check_admin";
    //ְҵ��������-����Ա
    public static final String ROLE_OCCUPATION_ADMIN ="role_occupation_admin";
    //����������-����Ա
    public static final String ROLE_HEALTH_ADMIN ="role_health_admin";
    //�����-����Ա
    public static final String ROLE_GENERAL_ADMIN ="role_general_admin";
    //�������-����Ա
    public static final String ROLE_PHYSICAL_ADMIN ="role_physical_admin";
    //��ɳͪ����-����Ա
    public static final String ROLE_METHADONE_ADMIN ="role_methadone_admin";
    //�����쵼-����Ա
    public static final String ROLE_CENTER_ADMIN ="role_center_admin";
    //������� -����ҽ��
    public static final String ROLE_DOCTOR_ADMIN ="role_doctor_admin";
    //�ƻ������-Э��Ա
    public static final String ROLE_FINANCIAL_COORDINATOR ="role_financial_coordinator";
    
    public static final int ROLE_ADMIN_ID = 1;
    
   /**
    * �û�״̬���塣
    * */
    public static final String DISABLE_F = "f";	
    public static final String DISABLE_T = "t";
    
    public static final String CHAR_TABLE = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    /**
	 * ϵͳ��־�ó������塣
	 */
	public static final String LOG_SEARCH_ACTIONTYPE_ALL = "ALL";
	public static final String LOG_SEARCH_ACTIONTYPE_CDCCHANGE = "CDC CHANGE";
	public static final String LOG_SEARCH_ACTIONTYPE_USERCHANGE = "USER CHANGE";
	public static final String LOG_ITEMTYPE_CDC = "C";
	public static final String LOG_ITEMTYPE_USER = "U";
	public static final String LOG_ITEMNAME_CDC = "CDC";
	public static final String LOG_ROLE_USER = "ROLE_USER";
	public static final String LOG_ROLE_ADMIN = "ROLE_ADMIN";
	public static final String LOG_ROLE_CSR = "ROLE_CSR";
	public static final String LOG_ROLE_CSRADMIN = "ROLE_CSRADMIN";
 
 
	public static final int MEDICAL_SIZE=15;
	public static int PAGESIZE=10;
	public static int PAGESIZES=100;
	//��ݷ��������
	public static final String AREA = "������";
    //�������
    public static final String AGENCY_LEVEL = "���м�";
    
	/**
	 * ϵͳ��Ϣ���塣
	 * */
    public static final String SYMPTOM = "֢״";
    public static final String DISEASE = "����";
    public static final String ALARMTHRESHOLD = "Ԥ����ֵ";
    public static final String MONITORDATA = "�����Ϣ";
    public static final String CHECKTASK = "��������";
    public static final String BATCHASSIGN = "����";
    public static final String ORIGINALRECORD = "ԭʼ��¼";
    public static final String ASSIGNSUCCESS = "����ɹ�";
    public static final String CONFIRMSUCCESS = "ȷ�ϳɹ�";
    public static final String SENDSUCCESS = "���¼���������ͳɹ�";
    public static final String CHECKSUCCESS = "У�˳ɹ�";
    public static final String HOSPITALSTERILIZE = "ҽԺ�������?";
    public static final String OCCUPATIONHEALTH = "������?";
    public static final String OCCUPATIONSAMPLE = "����";
    public static final String PURCHASEAPPLY = "�ɹ����뵥";
    public static final String PURCHASEAPPROVE = "����ɹ�";
    public static final String COSTCHECK = "����ɹ�";
    public static final String PURCHASECHECK = "�ɹ�״̬���óɹ�";
	public static final String addSuccess= "��ӳɹ�";
	public static final String editSuccess="�޸ĳɹ�";
	public static final String DELETE_SUCCESS="ɾ��ɹ�";
	public static final String OPERATE_SUCCESS="�����ɹ�";
	public static final String lockSuccess="��ɹ�";
	public static final String unlockSuccess="����ɹ�";
	public static final String openNetSuccess="����������ʳɹ�";
	public static final String closeNetSuccess="�ر�������ʳɹ�";
	public static final String userOperateFail="�����û�ʧ��! ��Ϊ�û�û�ж�Ӧ�ĸ�λ��û���κη���Ȩ�ޡ�";
	public static final String changePasswordSuccess="�û���Ϣ�޸ĳɹ�";
	public static final String originalPasswordFail="ԭ�������";
	public static final String monitorReportSuccess="��ⷽ�����ύ";
	public static final String monitorReportSaveSuccess="��ⷽ�������";
	public static final String REGISTRYSUCCESS="ע��ɹ���";
	public static final String REGISTRYFAIL="ע��ʧ�ܣ���������ȷ����Ȩע���룡";
	
	public static final String uploadSuccess="����ɹ���";
	public static final String uploadFail="����ʧ�ܣ�δ֪����";
	public static final String uploadNullTable="����ʧ�ܣ���ݿ��ж�Ӧ�?���ڣ�";
	public static final String uploadNotEqualColumns="����ʧ�ܣ�����ļ�����ԣ�";
	public static final String contentOrColumnsError="����ʧ�ܣ������ݻ�����ļ�����ԣ�";
	//�����ɽ�汾  �ӵ�
	public static final String APPRAISESUCCESS="���۳ɹ�";
	public static final String ACCEPTSUCCESS="����ɹ�";
	public static final String ADDSAMPLE="�������һ����Ʒ";
	public static final String COPYSUCCESS="���Ƴɹ�";
	public static final String ADDSSPECIMEN="�������һ���걾";
	public static final String TESTITEMS="����ѡ��һ�������Ŀ";
	public static final String NOTICESUCCESS="֪ͨ�ɹ�";
	public static final String CONFIRMATION="ȷ��֪ͨ�ɹ�";
	public static final String TETURNNOTICE="����֪ͨ�ɹ�";
	public static final String ABANDONEDSUCCESS="����ɹ�";
	public static final String ENABLEDSUCCESS="���óɹ�";
	public static final String NOISE="����";
	public static final String HIGHTEMPERATURE="����";
	public static final String HIV="���̲�";
	public static final String CONFIRMED="����ȷ֤";
	public static final String WB="WB����";
	public static final String HIVVIRALLOAD="��������";
	public static final String PRODUCTTEST="��Ʒ������?";
	public static final String CHECKNOTICE="У��֪ͨ�ɹ�";
	public static final String NOTTHROUGHAUDIT="���δͨ��";
	public static final String THROUGHAUDIT="���ͨ��";
	public static final String AUITFAIL="���δ�ɹ�";
	public static final String COMMONDETECTION="��ͨ�ֳ�������?";
	public static final String PUBLICPLACETEST="����������";
	public static final String WATERQUALITY="ˮ�ʼ��";
	public static final String PAYSUCCESS="�����ɹ�";
	public static final String SIGNSUCCESS="ǩ�ֳɹ�";
	//ע��ALLSecurityName ���ԡ�,����ʼ�����
	public static final String ALLSecurityName=",regist,,doctor,,test,,record,,management,,freeDrug,,nurse,,book,,vaccinate,," +
	  "plan,,drug,,drugDepot,,deptDrug,,drugApprove,,drugOutApprove,," +
	  "materialApprove,,standardApprove,,township,,auth,,analyse,," +
	  "charge,,call,,emergency,,train,,chronic,,ycchronic,,reportOneChronic,," +
	  "reportTwoChronic,,heartbrain,,heartbrainReport,,cancer,," +
	  "cancerReport,,cost,,purchaseCheck,,material,,materialOut,," +
	  "materials,,coordinator,,person,,salary,,cash,,maint,,attend,," +
	  "remedy,,lab,,task,,check,,reportEdit,,review,,sign,,flow,," +
	  "complaint,,device,,standard,,quality,,symptomReport,,symptom,," +
	  "epidemic,,studyNormal,,study,,balance,,kpi,,physicalOccupation,," +
	  "physicalEmploy,,physicalSign,,physicalXRay,,physicalLab,," +
	  "physicalNormal,,physicalStudent,,physicalDoctor,,occupationApply,," +
	  "occupationReview,,occupationExtract,,occupationDoctor,," +
	  "occupationResultReview,,occupationIssue,,occupationAll,,approve,";
}
