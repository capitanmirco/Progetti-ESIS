package com.esis.italia.course.example.jpa;

import java.io.Serializable;

public interface GenericEntity<ID> extends Serializable {
	ID getID();
}
