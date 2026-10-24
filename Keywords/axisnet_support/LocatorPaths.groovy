package axisnet_support

import support.CommonUtils
import support.LocatorUtil
import internal.GlobalVariable

public class LocatorPaths {
	//Quick Menu
	static final String DONASI_KUOTA_MENU = "AXISNet/Dashboard/Quick Menu - Donasi Kuota"
	static final String ISI_AIGO_MENU = "AXISNet/Dashboard/Quick Menu - Isi Aigo"
	static final String TENGGO_MENU = "AXISNet/Dashboard/Quick Menu - Tenggo"
	static final String BYOP_MENU = "AXISNet/Dashboard/Quick Menu - BYOP"
	static final String IOU_MENU = "AXISNet/Dashboard/Quick Menu - Pulsa Darurat"
	static final String ISI_PULSA_MENU = "AXISNet/Dashboard/Quick Menu - Isi Pulsa"
	static final String CONVERT_PULSA_MENU = "AXISNet/Dashboard/Quick Menu - Convert Pulsa"
	static final String LIHAT_SEMUA_MENU = "AXISNet/Dashboard/Quick Menu - Lihat Semua"
	static final String TRANSFER_PULSA_MENU = "AXISNet/Dashboard/Quick Menu - Transfer Pulsa"
	static final String TRANSFER_KUOTA_MENU = "AXISNet/Dashboard/Quick Menu - Transfer Kuota"

	//UAT Mode
	static final String SERVER_PAGE = "AXISNet/Debug Mode/Server Page"
	static final String SPINNER_MODE = "AXISNet/Debug Mode/Spinner List"
	static final String CHECKBOX_UAT_MODE = "AXISNet/Debug Mode/Check Box UAT Page"
	static final String CHECKBOX_PROD_MODE = "AXISNet/Debug Mode/Check Box Prod Page"
	static final String BUTTON_PILIH_SERVER = "AXISNet/Debug Mode/Button Pilih Server"

	//Dashboard
	static final String CHEVRON_KUOTA = "AXISNet/Dashboard/Chevron Kuota"
	static final String TEXT_VIEW_DETAIL_PAKET = "AXISNet/Dashboard/Text View Detail Paket"
	static final String BUTTON_MENU_PULSA_LAINNYA = "AXISNet/Dashboard/Button Menu Pulsa Lainnya"
	static final String IMG_BUTTON_LOCK_SERVICES = "AXISNet/Dashboard/Image Button Lock Services"
	static final String BUTTON_BONUS_PASTI = "AXISNet/Dashboard/Bonus Pasti"
	static final String DETAIL_BONUS_PASTI = "AXISNet/Dashboard/Detail Bonus Pasti"

	//Profile
	static final String BUTTON_PROFILE = "AXISNet/Profile/Button Profile"
	static final String BUTTON_BANTUAN = "AXISNet/Profile/Button Bantuan"
	static final String MAYA_PAGE = "AXISNet/Profile/Maya Page"
	static final String IMG_EDIT_PROFILE = "AXISNet/Profile/Button Edit Profile"
	static final String TOAST_SUCCESS_EDIT_PROFLE = "AXISNet/Profile/Toast Success Edit Profile"
	static final String BUTTON_KELUAR = "AXISNet/Profile/Button Keluar"
	static final String BUTTON_YA = "AXISNet/Profile/Button YA"

	//Bottom Navigation Menu
	static final String PLAYGROUND_MENU = "AXISNet/Dashboard/Bottom Navigation Menu - Playground"
	static final String PAKET_MENU = "AXISNet/Dashboard/Bottom Navigation Menu - Paket"
	static final String LIFESTYLE_MENU = "AXISNet/Dashboard/Bottom Navigation Menu - Lifestyle"
	static final String ALIFETIME_MENU = "AXISNet/Dashboard/Bottom Navigation Menu - Alifetime"

	//Confirmation & Receipt
	static final String BUTTON_KONFIRMASI= "AXISNet/Konfirmasi Receipt/Button Konfirmasi"
	static final String BUTTON_KE_HOME = "AXISNet/Konfirmasi Receipt/Button in Receipt - Ke Home"
	static final String PUSH_NOTIF_CALLBACK_TRANSACTION = "AXISNet/Konfirmasi Receipt/Push Notif Callback Transaction"
	static final String SYNCHRONOUS_PAGE = "AXISNet/Konfirmasi Receipt/Synch Page"
	static final String RECEIPT_SUCCESS = "AXISNet/Konfirmasi Receipt/Receipt Success"
	static final String RECEIPT_PROGRESS = "AXISNet/Konfirmasi Receipt/Receipt Progress"
	static final String RECEIPT_TENGGO_POP_UP = "AXISNet/Konfirmasi Receipt/Receipt Tenggo Pop Up"
	static final String TEXT_VIEW_AUTOREPURCHASE = "AXISNet/Konfirmasi Receipt/Text View Autorepurchase"
	static final String AUTOREPURCHASE_TOGGLE = "AXISNet/Konfirmasi Receipt/Text View Autorepurchase"

	//Transfer Pulsa
	static final String TF_PULSA_DEST_MSISDN = "AXISNet/Transfer Pulsa/Destination Number"
	static final String TF_PULSA_AMOUNT_5000 = "AXISNet/Transfer Pulsa/Pulsa Amount - 5000"
	static final String TF_PULSA_INVALID_MSISDN = "AXISNet/Transfer Pulsa/Transfer Pulsa Invalid Number"

	//Transfer Kuota
	static final String TF_KUOTA_DEST_MSISDN = "AXISNet/Transfer Kuota/Destination Number"
	static final String TF_KUOTA_CHECKBOX = "AXISNet/Transfer Kuota/Kuota Checkbox"
	static final String TF_KUOTA_AMOUNT_300MB = "AXISNet/Transfer Kuota/Kuota Amount 300"
	static final String TF_KUOTA_INVALID_MSISDN = "AXISNet/Transfer Kuota/Transfer Kuota Invalid Number"

	//Playground
	static final String BUTTON_HOME_SUCCESS_CLAIM_PLAYGROUND = "AXISNet/Playground/Button Home Success Claim Playground"

	//Playgoround Sureprize
	static final String PLAYGROUND_SUREPRIZE = "AXISNet/Playground/Sureprize"
	static final String BUTTON_SUREPRIZE_CLAIM = "AXISNet/Playground/Sureprize Claim Button"

	//Playground Mistery Box
	static final String PLAYGROUND_MISTERY_BOX = "AXISNet/Playground/Mistery Box Playground"
	static final String OPEN_BOX = "AXISNet/Playground/Open Box"
	static final String CLAIM_BUTTON_MISTERY_BOX = "AXISNet/Playground/Button Claim Mistery Box"

	//Playground Top Up Sureprize
	static final String PLAYGROUND_TOP_UP_SUREPRIZE = "AXISNet/Playground/Top Up Sureprize Playground"
	static final String CLAIM_BUTTON_TOP_UP_SUREPRIZE = "AXISNet/Playground/Button Claim Top Up Sureprize"
	static final String BUTTON_AMBIL_BONUS = "AXISNet/Playground/Button Ambil Sekarang Top Up Sureprize"
	static final String SWIPE_KEY_TOP_UP_SUREPRIZE = "AXISNet/Playground/Swipe Key Top Up Sureprize"

	//Alifetime
	static final String BONUS_KUOTA_EMERGENCY = 'AXISNet/Alifetime/Bonus Kuota Emergency'
	static final String BONUS_KUOTA_APLIKASI = 'AXISNet/Alifetime/Bonus Kuota Aplikasi'
	static final String BOOSTR_MASA_AKTIF = 'AXISNet/Alifetime/Boostr Masa Aktif'
	static final String BUTTON_TUKAR_SEKARANG = 'AXISNet/Alifetime/Button Tukar Sekarang'
	static final String BUTTON_KE_ALIFETIME = 'AXISNet/Alifetime/Button Ke Alifetime'
	static final String RANDOM_PAID_BONUS = 'AXISNet/Alifetime/Random Paid Bonus'
	static final String RANDOM_FREE_BONUS = 'AXISNet/Alifetime/Random Free Bonus'

	//Login Paths
	static final String AXIS_LETS_START_BUTTON = "AXISNet/Login Page/Lets Start Button"
	static final String AXIS_AGREE_PERMISSION_BUTTON = "AXISNet/Login Page/Agree Button"
	static final String MSISDN_FIELD = "AXISNet/Login Page/MSISDN Field"
	static final String AXIS_LOGIN_BUTTON = "AXISNet/Login Page/Login Button"
	static final String OTP_FIELD = "AXISNet/Login Page/OTP Field"
	static final String AXIS_CONTINUE_BUTTON = "AXISNet/Login Page/Continue Button"
	static final String SNK_PAGE_LOGIN = "AXISNet/Login Page/SNK Page"
	static final String BUTTON_SETUJU = "AXISNet/Login Page/Button Setuju"
	static final String TEXT_VIEW_INACTIVE_MSISDN = "AXISNet/Login Page/Inactive Msisdn"
	static final String ERR_WRONG_MSISDN = "AXISNet/Login Page/Error Wrong Msisdn"
	static final String ERR_MSISDN_LESS_THAN_11 = "AXISNet/Login Page/Error Less Than Msisdn 11 Digit"
	static final String VERIF_BIO_TEXT_VIEW = "AXISNet/Login Page/Verifikasi Biometrik Text"
	static final String IGNORE_SET_BIOMETRIC = "AXISNet/Login Page/Ignore Biometrik"
	static final String OTP_NOT_MATCH = "AXISNet/Login Page/OTP not Match"
	static final String OTP_REJECTION = "AXISNet/Login Page/OTP Rejection"

	//Medallia
	static final String MEDALLIA_TEXT = "AXISNet/Dashboard/Medallia Survey - Text View"
	static final String MEDALLIA_CLOSE_BUTTON = "AXISNet/Dashboard/Medallia - Close Button"

	//Donasi Kuota
	static final String BUTTON_DONASI = "AXISNet/Donasi Kuota/Donasi Button"
	static final String BUTTON_DONASI_SEKARANG = "AXISNet/Donasi Kuota/Donasi Sekarang Button"
	static final String CHECKBOX_KUOTA_DONASI = "AXISNet/Donasi Kuota/Choose Kuota"
	static final String BUTTON_PILIH_NOMINAL_DONASI = "AXISNet/Donasi Kuota/Pilih Nominal Donasi"
	static final String LIST_NOMINAL_DONASI_100 = "AXISNet/Donasi Kuota/Select Denom Donasi"
	static final String SUCCESS_DONASI = "AXISNet/Donasi Kuota/Success Donasi"
	static final String DONASI_LAGI_BUTTON = "AXISNet/Donasi Kuota/Button Donasi Lagi"
	static final String BUTTON_KEMBALI_KE_HOME = "AXISNet/Donasi Kuota/Button Kembali ke Home"

	//Isi Aigo
	static final String BUTTON_AKTIFKAN_VOUCHER = "AXISNet/Aigo/Button - Aktfikan Voucher"
	static final String AIGO_FIELD = "AXISNet/Aigo/Aigo Text Field"
	static final String AIGO_NOT_VALID = "AXISNet/Aigo/Aigo Text Not Valid"

	//Tenggo Package
	static final String TENGGO_TAB_3_JAM = "AXISNet/Tenggo/Tenggo Tab 3 Jam"
	static final String TENGGO_TAB_6_JAM = "AXISNet/Tenggo/Tenggo Tab 6 Jam"
	static final String TENGGO_TAB_12_JAM = "AXISNet/Tenggo/Tenggo Tab 12 Jam"
	static final String TENGGO_UTAMA_3_JAM = "AXISNet/Tenggo/Tenggo Utama 3 Jam"
	static final String TENGGO_TIKTOK_3_JAM = "AXISNet/Tenggo/Tenggo Tiktok 3 Jam"
	static final String TENGGO_BUTTON_OK = "AXISNet/Tenggo/Tenggo Button OK"
	static final String BUTTON_OK_RECEIPT_TENGGO_POPUP = "AXISNet/Tenggo/Tenggo Receipt Button OK"

	//Journey Purchase Package
	static final String BUTTON_AKTIFKAN = "AXISNet/Purchase Package Journey/Button Aktifkan"
	static final String IS_GIFTING = "AXISNet/Purchase Package Journey/is Gifting"
	static final String INSUFF_BALANCE_TEXT = "AXISNet/Purchase Package Journey/Text View Insuff Balance"
	static final String BUTTON_ISI_PULSA = "AXISNet/Purchase Package Journey/Button Isi Pulsa"
	static final String BUTTON_CHANGE_ACTIVATION_METHOD = "AXISNet/Purchase Package Journey/Button Ganti Metode Aktivasi"

	//Payment Method
	static final String BUTTON_PAYMENT_METHOD = "AXISNet/Payment Method/Button Payment Method"
	static final String PAYMENT_METHOD_SWIPE_KEY = "AXISNet/Payment Method/Payment Method Swipe Key"
	static final String PAYMENT_METHOD_PULSA = "AXISNet/Payment Method/Payment Pulsa"
	static final String PAYMENT_METHOD_DANA = "AXISNet/Payment Method/Payment Dana"
	static final String PAYMENT_METHOD_GOPAY = "AXISNet/Payment Method/Payment Gopay"
	static final String PAYMENT_METHOD_SHOPEEPAY = "AXISNet/Payment Method/Payment Shopeepay"
	static final String PAYMENT_METHOD_OVO = "AXISNet/Payment Method/Payment Ovo"
	static final String OVO_TEXT_FIELD = "AXISNet/Payment Method/Ovo Text Field Msisdn"
	static final String PAYMENT_METHOD_QR = "AXISNet/Payment Method/Payment QR"
	static final String INSUFF_BALANCE_MULTIPAYMENT = "AXISNet/Payment Method/Text View Insuf Balance Multipayment"
	static final String BUTTON_LANJUT_MULTIPAYMENT = "AXISNet/Payment Method/Button Lanjut Multipayment Insuff Balance"
	static final String BUTTON_CHANGE_PAYMENT_METHOD = "AXISNet/Payment Method/Button Ubah Metode Aktivasi"
	static final String ERROR_PAYMENT_NOTIFICATION = "AXISNet/Payment Method/Payment Error Notification"

	//Package Swipe Handling
	static final String PKG_SWIPE_KEY = "AXISNet/Package Handling/Package Swipe Key"
	static final String PKG_TAB_CONTAINER = "AXISNet/AxisnetPackages/Tab Container"

	//Active Button
	static final String BUTTON_LANJUT = "AXISNet/Purchase Package Journey/Button Lanjut"
	static final String AKTIVASI_SEKARANG = "AXISNet/Byop/Aktivasi Sekarang"
	static final String BUTTON_SIMPAN = "AXISNet/Byop/Button Simpan"
	static final String BUTTON_TAMBAH = "AXISNet/Byop/Button Tambah"
	static final String BUTTON_AKTIVASI = "AXISNet/Byop/Button Aktivasi"
	static final String BUTTON_NEXT_OTP_TRX = "AXISNet/Purchase Package Journey/Button Lanjut after Otp Trx"

	//Ribbon
	static final String RIBBON_TERCUCOK = "AXISNet/Byop/Ribbon Tercucok"
	static final String RIBBON_TERVIDIO = "AXISNet/Byop/Ribbon Tervidio"
	static final String RIBBON_TERHEMAT = "AXISNet/Byop/Ribbon TerHemat"

	//BYOP
	static final String OPEN_BYOP_CUSTOM = "AXISNet/Byop/Open Byop Custom"
	static final String OPEN_BYOP_RECOMMEDATION = "AXISNet/Byop/Open Byop Recommendation"
	static final String BYOP_VALIDITY_3D = "AXISNet/Byop/Byop Validity 3D"
	static final String BYOP_VALIDITY_7D = "AXISNet/Byop/Byop Validity 7D"
	static final String BYOP_VALIDITY_14D = "AXISNet/Byop/Byop Validity 14D"
	static final String BYOP_VALIDITY_28D = "AXISNet/Byop/Byop Validity 28D"
	static final String BYOP_RECOMM_VALIDITY_3D = "AXISNet/Byop/Byop Recommendation Validity 3D"
	static final String BYOP_RECOMM_VALIDITY_7D = "AXISNet/Byop/Byop Recommendation Validity 7D"
	static final String BYOP_RECOMM_VALIDITY_14D = "AXISNet/Byop/Byop Recommendation Validity 14D"
	static final String BYOP_RECOMM_VALIDITY_28D = "AXISNet/Byop/Byop Recommendation Validity 28D"
	static final String BYOP_PKG_INDEX_1 = "AXISNet/Byop/Byop Pkg Index 1"
	static final String BUTTON_ADD_ONS = "AXISNet/Byop/Button Add Ons"
	static final String FIRST_ADD_ONS_PKG = "AXISNet/Byop/First Add Ons Pkg Selection"
	static final String BUTTON_ADD_ON_CONFERENCE = "AXISNet/Byop/Button Add Conference"
	static final String ADD_ON_PKG_INDEX_1 = "AXISNet/Byop/Add On Pkg Index 1"
	static final String IGNORE_CHANGE_CUSTOM_NAME = "AXISNet/Byop/Button - Lain Kali"
	static final String BUTTON_CHANGE_CUSTOM_NAME = "AXISNet/Byop/Button - Ubah Nama Paket"
	static final String TEXT_VIEW_CHANGE_CUSTOM_NAME = "AXISNet/Byop/Text View - Pop Up Ganti Nama Paket"
	static final String TEXT_FIELD_CUSTOM_NAME_BYOP = "AXISNet/Byop/Text Field - Ubah Nama Paket"

	static final String BYOP_PERSONA_GGWP = "AXISNet/Byop/Persona GGWP"
	static final String BYOP_PERSONA_SOSMEDHOLIC = "AXISNet/Byop/Persona Sosmedholic"
	static final String BYOP_PERSONA_STREAMS = "AXISNet/Byop/Persona Streams"
	static final String BYOP_PERSONA_FYP = "AXISNet/Byop/Persona FYP"
	static final String BYOP_PERSONA_DRAKOR = "AXISNet/Byop/Persona Drakor"

	//Paket Category
	static final String CATEGORY_INTERNET_PROMO = "AXISNet/Kategori Paket/Paket List-Internet Promo"
	static final String CATEGORY_INTERNET = "AXISNet/Kategori Paket/Paket List-Internet"
	static final String CATEGORY_TENGGO = "AXISNet/Kategori Paket/Paket List-Teng-Go"
	static final String CATEGORY_BOOSTR = "AXISNet/Kategori Paket/Paket List-Boostr"
	static final String CATEGORY_ACTIVE_PERIOD = "AXISNet/Kategori Paket/Paket List-Masa Aktif"
	static final String CATEGORY_AXIS_ZONE = "AXISNet/Kategori Paket/Paket List-Axis Zone"
	static final String CATEGORY_LIFESTYLE = "AXISNet/Kategori Paket/Paket List-Lifestyle"
	static final String CATEGORY_CALL_SMS = "AXISNet/Kategori Paket/Paket List-Telp Sms"
	static final String CATEGORY_ROAMING = "AXISNet/Kategori Paket/Paket List-Roaming"
	static final String CATEGORY_BRONET = "AXISNet/Kategori Paket/Paket List-Bronet"

	//Internet Page
	static final String JUMAT_BAIK_TAB = "AXISNet/Internet Section/Jumat Baik Tab"
	static final String RABU_RAWIT_TAB = "AXISNet/Internet Section/Rabu Rawit Tab"
	static final String BOOSTR_WEEKEND_TAB = "AXISNet/Internet Section/Boostr Weekend Tab"
	static final String BRONET_TAB = "AXISNet/Internet Section/Bronet Tab"
	static final String WARNET_TAB = "AXISNet/Internet Section/Warnet Tab"

	//Game Token
	static final String TOGGLE_SWITCH = "AXISNet/Entertainment/Switch Toggle Gaming"
	static final String GAME_TOKEN_FF = "AXISNet/Entertainment/Game Token FF"
	static final String GAME_TOKEN_PUBG = "AXISNet/Entertainment/Game Token PUBG"
	static final String GAME_TOKEN_MLBB = "AXISNet/Entertainment/Game Token MLBB"
	static final String GAME_TOKEN_USER_ID = "AXISNet/Entertainment/Game Token User Id"
	static final String GAME_TOKEN_ZONE_ID = "AXISNet/Entertainment/Game Token Zone Id"
	static final String GAME_TOKEN_TOP_UP_1 = "AXISNet/Entertainment/Game Token Top Up Index 1"
	static final String TRANSACTION_OTP_FIELD = "AXISNet/Entertainment/OTP Transaksi"
	static final String ERR_INVALID_OTP_GAME_TOKEN = "AXISNet/Entertainment/Invalid OTP"
	static final String FAILED_ACTIVATE_UNL_GAMING = "AXISNet/Entertainment/Failed Activate Unl Gaming"
	static final String BUTTON_OK = "AXISNet/Entertainment/Button OK"

	//MCCM Hanya Untukmu
	static final String FOREVER_ONLINE_PKG_7D = "AXISNet/Purchase Package Journey/Forever Online Pkg"
	static final String FOREVER_ONLINE_TAB = "AXISNet/Purchase Package Journey/Forever Online Tab"

	//IOU
	static final String SWIPE_KEY_LANDING_PAGE_IOU = "AXISNet/Iou/Swipe Key IOU"
	static final String BUTTON_GUNAKAN_IOU = "AXISNet/Iou/Button Gunakan Pulsa Darurat"
	static final String BUTTON_PINJAM = "AXISNet/Iou/Button Pinjam"
	static final String BUTTON_LANJUT_IOU = "AXISNet/Iou/Button Lanjut IOU"
	static final String CHECKBOX_IOU = "AXISNet/Iou/Check Box IOU"
	static final String LOAN_1000 = "AXISNet/Iou/Loan 1000"
	static final String LOAN_2000 = "AXISNet/Iou/Loan 2000"
	static final String LOAN_3000 = "AXISNet/Iou/Loan 3000"
	static final String LOAN_4000 = "AXISNet/Iou/Loan 4000"
	static final String LOAN_5000 = "AXISNet/Iou/Loan 5000"
	static final String LOAN_7000 = "AXISNet/Iou/Loan 7000"
	static final String LOAN_10000 = "AXISNet/Iou/Loan 10000"

	//Lock & Unlock Service
	static final String INTERNET_SERVICE = "AXISNet/Lock Unlock/Internet"
	static final String SMS_SERVICE = "AXISNet/Lock Unlock/SMS"
	static final String CALL_SERVICE = "AXISNet/Lock Unlock/Telepon"
	static final String MSG_SUCCESS_SETUP_SERVICES = "AXISNet/Lock Unlock/Message Success Lock Unlock"

	//Entertainment
	static final String PAKET_NONTON_TAB = "AXISNet/Entertainment/Paket Nonton Tab"
	static final String PAKET_PREMIUM_TAB = "AXISNet/Entertainment/Paket Premium Tab"
	static final String PAKET_NONTON_BANNER_1 = "AXISNet/Entertainment/Banner Nonton 1"
	static final String PAKET_PREMIUM_BANNER_1 = "AXISNet/Entertainment/Banner Premium 1"
	static final String PAKET_PREMIUM_BANNER_2 = "AXISNet/Entertainment/Banner Premium 2"
	static final String PREMIUM_GTUNES_300MB = "AXISNet/Entertainment/Gtunes 300MB"
	static final String NONTON_CATCHPLAY_LITE_7HR = "AXISNet/Entertainment/Catchplay Lite 7Hr"
	static final String NONTON_CATCHPLAY_SINGLE_RENTAL_7HR = "AXISNet/Entertainment/Catchplay Single Rental 7Hr"
	static final String PREMIUM_UDEMY_7HR = "AXISNet/Entertainment/Udemy Edu 7Hr"
	static final String REKREAXIS_MENU = "AXISNet/Entertainment/Rekreaxis Menu"
	static final String BUTTON_KE_REKREAXIS = "AXISNet/Entertainment/Button Ke Rekreaxis"
	static final String REKREAXIS_PAGE = "AXISNet/Entertainment/Rekreaxis Page"

	//Isi Pulsa
	static final String TOP_UP_25K = "AXISNet/Isi Pulsa/Top Up 25K"
	static final String TOP_UP_50K = "AXISNet/Isi Pulsa/Top Up 50K"
	static final String TOP_UP_100K = "AXISNet/Isi Pulsa/Top Up 100K"
	static final String ISI_PULSA_PAYMENT_METHOD = "AXISNet/Isi Pulsa/Isi Pulsa Payment Method"

	//----Internet Package----

	//Swipe Key Tab
	static final String SWIPE_KEY_PKG_TAB = "AXISNet/Internet Section/Swipe Key Pkg Tab"

	//Warnet Unlimited
	static final String WARNET_UNL_1JAM = "AXISNet/Internet Section/Warnet Unl 1 Jam"
	static final String WARNET_UNL_3JAM = "AXISNet/Internet Section/Warnet Unl 3 Jam"
	static final String WARNET_UNL_24JAM = "AXISNet/Internet Section/Warnet Unl 24 Jam"
	static final String WARNET_UNL_48JAM = "AXISNet/Internet Section/Warnet Unl 48 Jam"
	static final String WARNET_UNL_72JAM = "AXISNet/Internet Section/Warnet Unl 72 Jam"

	//Warnet Regular
	static final String WARNET_REG_1JAM = "AXISNet/Internet Section/Warnet Regular 1 Jam"
	static final String WARNET_REG_2JAM = "AXISNet/Internet Section/Warnet Regular 2 Jam"
	static final String WARNET_REG_3JAM = "AXISNet/Internet Section/Warnet Regular 3 Jam"

	//Bronet Sosmed
	static final String BRONET_SOSMED_5GB_3HR = "AXISNet/Internet Section/Bronet Sosmed 5GB 3Hr"

	//Bronet 24 Jam
	static final String BRONET_24JAM_10GB_28HR = "AXISNet/Bronet Section/Bronet 24 jam 10GB 28Hr"
	static final String BRONET_GO_75GB_14HR = "AXISNet/Bronet Section/Bronet GO 7.5GB 14Hr"

	//Minta Bayarin
	static final String BUTTON_MINTA_BAYARIN = "AXISNet/Purchase Package Journey/Button Minta Bayarin"
	static final String BUTTON_LANJUT_MINTA_BAYARIN = "AXISNet/Purchase Package Journey/Button Oke, Lanjut"
	static final String BUTTON_BAGIKAN_QR = "AXISNet/Purchase Package Journey/Button Share Qr"

	//Limited Offer
	static final String SWIPE_LO_PKG = "AXISNet/Dashboard/Swipe Key LO Pkg"
	static final String LIMITED_OFFER_BUTTON = "AXISNet/Dashboard/Mendadak Diskon"
	static final String LIMITED_OFFER_SWIPE_UP = "AXISNet/Dashboard/Swipe Up"

	//Gifting
	static final String GIFTING_BUTTON = "AXISNet/Purchase Package Journey/Gifting Button"
	static final String GIFTING_TEXT_FIELD = "AXISNet/Purchase Package Journey/Gifting Text Field"

	//Pop Up Permissions
	static final String LOCATION_PERMISSION = "AXISNet/Permissions/Location"
	static final String NOTIFICATION_PERMISSION = "AXISNet/Permissions/Notification"
	static final String PHONE_CALLS_PERMISSION = "AXISNet/Permissions/Phone Calls"
	static final String PERMISSION_BUTTON_ALLOW = "AXISNet/Permissions/Button Allow"
	static final String PERMISSION_BUTTON_WHILE_USING_APP = "AXISNet/Permissions/Button While using the App"

	//Convert Pulsa
	static final String CONVERT_PULSA_INTRODUCTION = "AXISNet/Convert Pulsa/First Time Introduction"
	static final String CONVERT_PULSA_BENEFIT = "AXISNet/Convert Pulsa/Benefit Page"
	static final String BUTTON_LANJUTKAN = "AXISNet/Convert Pulsa/Button Lanjutkan"
	static final String CONVERT_PULSA_INVALID_NUMBER = "AXISNet/Convert Pulsa/Pop Up Invalid Msisdn"
	static final String BUTTON_KIRIM_KE_ORANG_LAIN = "AXISNet/Convert Pulsa/Button Kirim Ke Orang Lain"

	//Shopeepay WebView
	static final String BUTTON_SHOPEEPAY_PAY_NOW = "AXISNet/Webview/Shopeepay - Button Bayar Sekarang"
	static final String SHOPEEPAY_KEYBOARD_0 = "AXISNet/Webview/Shopeepay - Keyboard 0"
	static final String SHOPEEPAY_KEYBOARD_1 = "AXISNet/Webview/Shopeepay - Keyboard 1"
	static final String SHOPEEPAY_KEYBOARD_2 = "AXISNet/Webview/Shopeepay - Keyboard 2"
	static final String SHOPEEPAY_KEYBOARD_3 = "AXISNet/Webview/Shopeepay - Keyboard 3"
	static final String SHOPEEPAY_KEYBOARD_4 = "AXISNet/Webview/Shopeepay - Keyboard 4"
	static final String SHOPEEPAY_KEYBOARD_5 = "AXISNet/Webview/Shopeepay - Keyboard 5"
	static final String SHOPEEPAY_KEYBOARD_6 = "AXISNet/Webview/Shopeepay - Keyboard 6"
	static final String SHOPEEPAY_KEYBOARD_7 = "AXISNet/Webview/Shopeepay - Keyboard 7"
	static final String SHOPEEPAY_KEYBOARD_8 = "AXISNet/Webview/Shopeepay - Keyboard 8"
	static final String SHOPEEPAY_KEYBOARD_9 = "AXISNet/Webview/Shopeepay - Keyboard 9"
	static final String SHOPEEPAY_FAILED_PIN = "AXISNet/Webview/Shopeepay - Failed Pin"

	static final String BUTTON_SPAY_INTERNAL_APP_PAY_NOW = "AXISNet/Webview/Spay Internal App - Bayar Sekarang"

	//Dana Webview
	static final String BUTTON_BAYAR_PAKAI_DANA = "AXISNet/Webview/Dana - Bayar Pakai Dana"
	static final String CHECKBOX_STORE = "AXISNet/Webview/CheckBox Store"
	static final String BUTTON_BAYAR = "AXISNet/Webview/Dana - Button Bayar"

	// ---- PENGAMBILAN DINAMIS MENGGUNAKAN FUNGSI ----

	static String dynamicPackageCard(String packageName) {
		// Panggil getLocatorPath di sini, BUKAN di deklarasi class variabel
		String rawXPath = LocatorUtil.getLocatorPath("AXISNet/AxisnetPackages/Dynamic Package Card")
		return LocatorUtil.getDynamicXPath(rawXPath, packageName)
	}

	static String dynamicPackagePrice(String packageName) {
		String rawXPath = LocatorUtil.getLocatorPath("AXISNet/AxisnetPackages/Dynamic Package Price")
		return LocatorUtil.getDynamicXPath(rawXPath, packageName)
	}

	static String dynamicMainCategory(String categoryName) {
		String rawXPath = LocatorUtil.getLocatorPath("AXISNet/AxisnetPackages/Dynamic Main Category")
		return LocatorUtil.getDynamicXPath(rawXPath, categoryName)
	}

	static String dynamicTabCategory(String tabName) {
		String rawXPath = LocatorUtil.getLocatorPath("AXISNet/AxisnetPackages/Dynamic Tab Category")
		return LocatorUtil.getDynamicXPath(rawXPath, tabName)
	}
}