package com.sdpk.query.service;

import java.util.ArrayList;

import com.sdpk.model.PaikeRecordView;
import com.sdpk.model.PaikeSearch;

public interface QueKeService {

	ArrayList<PaikeRecordView>getAllpaike(PaikeSearch paikeSearch);
}
