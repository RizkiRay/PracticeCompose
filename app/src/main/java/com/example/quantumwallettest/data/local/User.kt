package com.example.quantumwallettest.data.local

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.util.TableInfo
import kotlinx.android.parcel.Parcelize
import org.jetbrains.annotations.NotNull


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 12/06/23.
 */

@Parcelize
@Entity(tableName = "users", indices = [Index(value = ["phone"], unique = true)])
data class User(
    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "email")
    var email: String,

    @NotNull
    @ColumnInfo(name = "phone")
    var phone: String
) : Parcelable