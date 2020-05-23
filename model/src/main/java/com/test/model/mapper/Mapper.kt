package com.test.model.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}
