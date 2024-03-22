package com.example.json_editing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val disclosures = listOf(
            "WyJtN2ZmSGJrbWJMemtSdWw0bkgxekN3IiwibGFzdE5hbWUiLCJEb2UiXQ==",
            "WyJjdUZSSXRwaEViVE9IOU4zTHh1VE1RIiwic2VyaWFsTnVtYmVyIiwiMTIzNDUiXQ==",
            "WyJMZWVCeWJ6Uk1YWEtRVjVRNm5sc09RIiwiZ2VuZGVyIiwiTWFsZSJd",
            "WyJveThaaW9kY0diNWR1RGZwc0dwVy1RIiwiZmlyc3ROYW1lIiwiSm9obiJd",
            "WyJOSzIzX0F6dmdPclFjc3NNUGItVEV3IiwibmF0aW9uYWxpdHkiLCJFVSJd"
        )
        val originalJson = """{
  "@context": [
    "https://www.w3.org/2018/credentials/v1",
    "https://purl.imsglobal.org/spec/ob/v3p0/context.json"
  ],
  "id": "urn:uuid:ca2bd80d-d953-41fa-a033-53930bd5e5c0",
  "type": [
    "VerifiableCredential",
    "Passport"
  ],
  "name": "JFF x vc-edu PlugFest 3 Interoperability",
  "issuer": {
    "type": [
      "Profile"
    ],
    "id": "did:key:z6MkjoRhq1jSNJdLiruSXrFFxagqrztZaXHqHGUTKJbcNywp",
    "name": "Jobs for the Future (JFF)",
    "url": "https://www.jff.org/",
    "image": "https://w3c-ccg.github.io/vc-ed/plugfest-1-2022/images/JFF_LogoLockup.png"
  },
  "issuanceDate": "2024-03-19T10:54:03.017124893Z",
  "expirationDate": "2025-03-19T10:54:03.017160173Z",
  "credentialSubject": {
    "cred": {
      "_sd": [
        "9soGNMzf-tbcvnTgnt8oWCRPve6EphhNX8BHbieIJ-A",
        "jw-ybk660khxWyQhu29rN_PF6LTSy5m6vOC2tGOIW74",
        "cVl5HkJyjv_vTPGWbun11gbgd2mDWzyhew-1OPkmh6g",
        "IBFmE-8fcoAVSPkmzA6VMbArMJHiPmNXgeXbnDlQWy8",
        "50ZJpOPR3B0Z3tbjUeK-fexOTt8zoEdL80-1nXZ4c38"
      ]
    },
    "serialNumber": "12345",
    "personalNumber": "123456789",
    "issuerAuthority": "EU",
    "expiryDate": "12-12-2026",
    "id": "did:key:z2dmzD81cgPx8Vki7JbuuMmFYrWPgYoytykUZ3eyqht1j9KbndeoNhFTpdnkqkkC85C6ChoYBrhrRrjGu7dW5TrChVuKusBiy8Wrz6Gmz9WC2fBB5qtc1B6uDeLHmzNLVQxqQwkDT2WdSFsYVMswYYePR9T5xNF9xMiz2UbBQ9JeGsNMPi#z2dmzD81cgPx8Vki7JbuuMmFYrWPgYoytykUZ3eyqht1j9KbndeoNhFTpdnkqkkC85C6ChoYBrhrRrjGu7dW5TrChVuKusBiy8Wrz6Gmz9WC2fBB5qtc1B6uDeLHmzNLVQxqQwkDT2WdSFsYVMswYYePR9T5xNF9xMiz2UbBQ9JeGsNMPi",
    "_sd": [
        "9soGNMzf-tbcvnTgnt8oWCRPve6EphhNX8BHbieIJ-A",
        "jw-ybk660khxWyQhu29rN_PF6LTSy5m6vOC2tGOIW74",
        "cVl5HkJyjv_vTPGWbun11gbgd2mDWzyhew-1OPkmh6g",
        "IBFmE-8fcoAVSPkmzA6VMbArMJHiPmNXgeXbnDlQWy8",
        "50ZJpOPR3B0Z3tbjUeK-fexOTt8zoEdL80-1nXZ4c38"
    ]
  },
  "_sd": [
        "9soGNMzf-tbcvnTgnt8oWCRPve6EphhNX8BHbieIJ-A",
        "jw-ybk660khxWyQhu29rN_PF6LTSy5m6vOC2tGOIW74",
        "cVl5HkJyjv_vTPGWbun11gbgd2mDWzyhew-1OPkmh6g",
        "IBFmE-8fcoAVSPkmzA6VMbArMJHiPmNXgeXbnDlQWy8",
        "50ZJpOPR3B0Z3tbjUeK-fexOTt8zoEdL80-1nXZ4c38"
  ]
}"""
        val modifiedJson = JsonModifier.addTestKey(originalJson, disclosures)
        println("Resulted json is :$modifiedJson")
    }
}