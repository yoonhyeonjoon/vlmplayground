/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.vlmplayground.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.vlmplayground.core.model.data.Bulletin
import java.util.*


@Entity(
    tableName = "bulletinboard",
)
data class BulletinEntity(
//    @PrimaryKey(autoGenerate = true)
//    val id: Long? = 0,
    @PrimaryKey
    @ColumnInfo(defaultValue = "")
    val fid: String,
    @ColumnInfo(defaultValue = "")
    val images: String, //["images/125.jpg","images/248.jpg","images/224.jpg","images/038.jpg"] 의 형태로 저장
    @ColumnInfo(defaultValue = "")
    val score: String,
    val date: Date,
    @ColumnInfo(defaultValue = "")
    val name : String,
    @ColumnInfo(defaultValue = "")
    val text : String,
    @ColumnInfo(defaultValue = "")
    val title : String,
    var synced : Boolean = false,
    @ColumnInfo(defaultValue = "dry")
    var requestoption : String = "dry" // 1. "dry" = nothing cnofirmed, 2. "delete", 3. "upload" => upload 옵션은 basically modified set option for firebase를 의미 함

)


fun BulletinEntity.asDataModel() = Bulletin(
    fid = fid,
    images = images.split(","),
    date = date,
    score = score.toLong(),
    name = name,
    text = text,
    title = title,
)
