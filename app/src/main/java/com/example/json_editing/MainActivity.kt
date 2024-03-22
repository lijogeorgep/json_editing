package com.example.json_editing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
        "wF5TbYXU4HbnvbF0g1Va2-ZHVfqiS2Vkc-CAWeG6wkM",
        "KrDmv1US2-_d90CB_InqafeaDSA8uuENnhPTWVTxVlQ",
        "9GgTnIjhELkbzYBCyTsiSpKNPyhg9lHe2TlHQp-g89E",
        "uJBaaIIMN9sP2910fEb9hoJk0bHJaWT7VJRL6cU1XoA",
        "SLC7qU0XIHAcV2r3nOLt43btfAnOw216Z00K-Cd2uVc"
      ]
    },
    "serialNumber": "12345",
    "personalNumber": "123456789",
    "issuerAuthority": "EU",
    "expiryDate": "12-12-2026",
    "id": "did:key:z2dmzD81cgPx8Vki7JbuuMmFYrWPgYoytykUZ3eyqht1j9KbndeoNhFTpdnkqkkC85C6ChoYBrhrRrjGu7dW5TrChVuKusBiy8Wrz6Gmz9WC2fBB5qtc1B6uDeLHmzNLVQxqQwkDT2WdSFsYVMswYYePR9T5xNF9xMiz2UbBQ9JeGsNMPi#z2dmzD81cgPx8Vki7JbuuMmFYrWPgYoytykUZ3eyqht1j9KbndeoNhFTpdnkqkkC85C6ChoYBrhrRrjGu7dW5TrChVuKusBiy8Wrz6Gmz9WC2fBB5qtc1B6uDeLHmzNLVQxqQwkDT2WdSFsYVMswYYePR9T5xNF9xMiz2UbBQ9JeGsNMPi",
    "_sd": [
      "wF5TbYXU4HbnvbF0g1Va2-ZHVfqiS2Vkc-CAWeG6wkM",
      "KrDmv1US2-_d90CB_InqafeaDSA8uuENnhPTWVTxVlQ",
      "9GgTnIjhELkbzYBCyTsiSpKNPyhg9lHe2TlHQp-g89E",
      "uJBaaIIMN9sP2910fEb9hoJk0bHJaWT7VJRL6cU1XoA",
      "SLC7qU0XIHAcV2r3nOLt43btfAnOw216Z00K-Cd2uVc"
    ]
  },
  "_sd": [
    "wF5TbYXU4HbnvbF0g1Va2-ZHVfqiS2Vkc-CAWeG6wkM",
    "KrDmv1US2-_d90CB_InqafeaDSA8uuENnhPTWVTxVlQ",
    "9GgTnIjhELkbzYBCyTsiSpKNPyhg9lHe2TlHQp-g89E",
    "uJBaaIIMN9sP2910fEb9hoJk0bHJaWT7VJRL6cU1XoA",
    "SLC7qU0XIHAcV2r3nOLt43btfAnOw216Z00K-Cd2uVc"
  ]
}"""
        val modifiedJson = JsonModifier.addTestKey(originalJson)
        println("Resulted json is :$modifiedJson")
    }
}