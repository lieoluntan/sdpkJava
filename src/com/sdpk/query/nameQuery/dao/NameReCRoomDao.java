package com.sdpk.query.nameQuery.dao;

import java.util.List;


import com.sdpk.model.ClassRoom;

public interface NameReCRoomDao {

	public List<ClassRoom> getCRByName(ClassRoom cR);
}
