package com.sdpk.query.dao;

import java.util.ArrayList;

import com.sdpk.model.PaikeRecordView;
import com.sdpk.model.PaikeSearch;

public interface QueKeDao {

	ArrayList<PaikeRecordView>getAllpaike(PaikeSearch paikeSearch);
}
