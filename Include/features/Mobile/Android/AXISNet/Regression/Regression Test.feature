Feature: Regression


Background:
  Given user opens axisnet application test
  When user perform login into the axis app with number "083110568390" and otp "DT2022"

@Donasi_Kuota
Scenario: Perform Donasi Kuota
And user swipes "left" on element "AXISNet/Dashboard/Quick Menu - Donasi Kuota" 1 times
And user click on Quick Menu Donasi Kuota element "AXISNet/Dashboard/Quick Menu - Donasi Kuota"
And user scrolls to "Sekolah"
And user click on Donasi Button element "AXISNet/Donasi Kuota/Donasi Button"
And user click on Donasi Sekarang Button element "AXISNet/Donasi Kuota/Donasi Sekarang Button"
And user click on Radio for Choose Kuota element "AXISNet/Donasi Kuota/Choose Kuota"
And user click on Pilih Nominal Donasi Button element "AXISNet/Donasi Kuota/Pilih Nominal Donasi"
And user click on List Denom Kuota element "AXISNet/Donasi Kuota/Select Denom Donasi"
And user click on Konfimasi Button element "AXISNet/Donasi Kuota/Konfirmasi Button"
Then user expect to see the Success Donasi Page element "AXISNet/Donasi Kuota/Success Donasi"