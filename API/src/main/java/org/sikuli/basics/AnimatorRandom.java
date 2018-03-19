/*
 * Copyright (c) 2010-2017, sikuli.org, sikulix.com - MIT license
 */

package org.sikuli.basics;
import java.lang.Math;

public class AnimatorRandom extends AnimatorTimeValueFunction {

  float
  prevoius_linear_value,
  random_modifyer,
  upper,
  lower,
  maxRandom; 
  
  float 
  randomFactor = (float) 0.002;

  public AnimatorRandom(float beginVal, float endVal, long totalTime) {
    super(beginVal, endVal, totalTime);
    upper = (float)  randomFactor * Math.abs(beginVal - endVal);
    lower = (float) -randomFactor * Math.abs(beginVal - endVal);
    maxRandom =  Math.abs(beginVal - endVal) * (float) 0.2;
  }

  @Override
  public float getValue(long t) {
    if (t > _totalTime) {
      return _endVal;
    }
    double t1 = (double) t / _totalTime;
    double t2 = t1 * t1;
    float result = (float) (_beginVal
            + (_endVal - _beginVal) * (-1 * t2 * t2 + 4 * t1 * t2 - 6 * t2 + 4 * t1));

    float
    r = (float) (Math.random() * (upper - lower)) + lower,
    halfOfTotalTime = _totalTime/2,
    window = (halfOfTotalTime - Math.abs(halfOfTotalTime - t))/halfOfTotalTime;

    if (Math.abs(random_modifyer + r) < maxRandom)
      random_modifyer += r;
    else
      random_modifyer -= r;

    result += random_modifyer * window;
    return result;
  }
}
