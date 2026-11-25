package com.huongdanjava.lombok;

import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@RequiredArgsConstructor
public class Student {

  private String name;

  @Setter(AccessLevel.PRIVATE)
  @NonNull
  private String code;

  @Getter(AccessLevel.PROTECTED)
  private LocalDate dateOfBirth;
}
