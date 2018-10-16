/*
 * This class holds the bulk of the working calculations for the calcuator
 * and is mostly static.
 * Drew White 92017830
 * 3/4/17
 */
package calculatorproject;

//@author 92017830
public class Calculations extends CalculatorFrame {

    //List of variables for use in calculations.
    private static double total = 0;
    private static char operator1 = 'a';
    private static char operator2 = 'a';
    //Operator 3 is not currently used
    private static char operator3 = 'a';
    private static double value1;
    private static double value2;
    public static boolean numComplete = true;

    //@return the total
    public double getTotal() {
        return total;
    }

    //@param total the total to set
    public void setTotal(double total) {
        this.total = total;
    }

    //@return the operator1
    public static char getOperator1() {
        return operator1;
    }

    //@param operator1 the operator1 to set
    public void setOperator1(char Operator1) {
        this.operator1 = Operator1;
    }

    //@return the operator2
    public static char getOperator2() {
        return operator2;
    }

    //@param operator2 the operator2 to set
    public void setOperator2(char Operator2) {
        this.operator2 = Operator2;
    }

    //@return the operator3
    public static char getOperator3() {
        return operator3;
    }

    //@param operator3 the operator3 to set
    public void setOperator3(char Operator3) {
        this.operator3 = Operator3;
    }

    //@return the value1
    public static double getValue1() {
        return value1;
    }

    //@param value1 the value1 to set
    public void setValue1(double value1) {
        this.value1 = value1;
    }

    //@return the value2
    public static double getValue2() {
        return value2;
    }

    //@param value2 the value2 to set
    public void setValue2(double value2) {
        this.value2 = value2;
    }

    //When "+" button is pushed
    public static String plusPushed(String value) {

        if (operator1 == 'a') {
            total = Double.parseDouble(value);
        } else if (operator1 == '+') {
            total = total + Double.parseDouble(value);
        } else if (operator1 == '-') {
            total = total - Double.parseDouble(value);
        } else if (operator1 == '*') {
            if (operator2 == 'a') {
                total = value1 * Double.parseDouble(value);
            } else if (operator2 == '+') {
                total = total + (value1 * Double.parseDouble(value));
            } else if (operator2 == '-') {
                total = total - (value1 * Double.parseDouble(value));
            }
        } else if (operator1 == '/') {
            if (operator2 == 'a') {
                total = value1 / Double.parseDouble(value);
            } else if (operator2 == '+') {
                total = total + value1 / Double.parseDouble(value);
            } else if (operator2 == '-') {
                total = total - value1 / Double.parseDouble(value);
            }
        } else if (operator1 == '^') {
            if (operator2 == '+') {
                total = total + Math.pow(value2, Double.parseDouble(value));
            } else if (operator2 == '-') {
                total = total - Math.pow(value2, Double.parseDouble(value));
            } else if (operator2 == '*') {
                total = total + value1 * Math.pow(value2, Double.parseDouble(value));
            } else if (operator2 == '/') {
                total = total + value1 / Math.pow(value2, Double.parseDouble(value));
            }
        }

        operator1 = '+';
        //operator2 = 'a';
        numComplete = true;
        String result = Double.toString(total);
        return result;
    }

    //When Subtract button pushed
    public static String minusPushed(String value) {
        try {
            if (operator1 == 'a') {
                total = Double.parseDouble(value);
            } else if (operator1 == '+') {
                total = total + Double.parseDouble(value);
            } else if (operator1 == '-') {
                total = total - Double.parseDouble(value);
            } else if (operator1 == '*') {
                if (operator2 == 'a') {
                    total = value1 * Double.parseDouble(value);
                }
                if (operator2 == '+') {
                    total = total + (value1 * Double.parseDouble(value));
                } else if (operator2 == '-') {
                    total = total - (value1 * Double.parseDouble(value));
                }
            } else if (operator1 == '/') {
                if (operator2 == 'a') {
                    total = value1 / Double.parseDouble(value);
                } else if (operator2 == '+') {
                    total = total + (value1 / Double.parseDouble(value));
                } else if (operator2 == '-') {
                    total = total + (value1 / Double.parseDouble(value));
                    operator1 = '-';
                }
            } else if (operator1 == '^') {
                if (operator2 == '+') {
                    total = total + Math.pow(value2, Double.parseDouble(value));
                } else if (operator2 == '-') {
                    total = total - Math.pow(value2, Double.parseDouble(value));
                } else if (operator2 == '*') {
                    total = total + value1 * Math.pow(value2, Double.parseDouble(value));
                } else if (operator2 == '/') {
                    total = total + value1 / Math.pow(value2, Double.parseDouble(value));
                }
            }
        } catch (Exception e) {

        }
        operator1 = '-';
        //operator2 = 'a';
        numComplete = true;
        String result = Double.toString(total);
        return result;
    }

    //When multiply button pushed
    public static String multiplyPushed(String value) {
        try {
            if (operator1 == 'a') {
                value1 = Double.parseDouble(value);
            } else if (operator1 == '+') {
                value1 = Double.parseDouble(value);
                operator2 = '+';
            } else if (operator1 == '-') {
                value1 = Double.parseDouble(value);
                operator2 = '-';
            } else if (operator1 == '*') {
                value1 = value1 * Double.parseDouble(value);
            } else if (operator1 == '/') {
                value1 = value1 / Double.parseDouble(value);
            } else if (operator1 == '^') {
                if (operator2 == '+') {
                    value1 = value1 + Math.pow(value2, Double.parseDouble(value));
                } else if (operator2 == '-') {
                    value1 = value1 - Math.pow(value2, Double.parseDouble(value));
                } else if (operator2 == '/') {
                    value1 = value1 / Math.pow(value2, Double.parseDouble(value));
                } else if (operator2 == '*') {
                    value1 = value1 * Math.pow(value2, Double.parseDouble(value));
                }
            }

        } catch (Exception e) {

        }
        numComplete = true;
        operator1 = '*';
        String result = Double.toString(value1);
        return result;
    }

    //When Division button is pushed
    public static String dividePushed(String value) {
        try {
            if (operator1 == 'a') {
                value1 = Double.parseDouble(value);
            } else if (operator1 == '+') {
                operator2 = '+';
                value1 = Double.parseDouble(value);
            } else if (operator1 == '-') {
                operator2 = '-';
                value1 = Double.parseDouble(value);
            } else if (operator1 == '*') {
                value1 = value1 * Double.parseDouble(value);
            } else if (operator1 == '/') {
                value1 = value1 / Double.parseDouble(value);
            } else if (operator1 == '^') {
                if (operator2 == '+') {
                    value1 = value1 + Math.pow(value2, Double.parseDouble(value));
                } else if (operator2 == '-') {
                    value1 = value1 - Math.pow(value2, Double.parseDouble(value));
                } else if (operator2 == '/') {
                    value1 = value1 / Math.pow(value2, Double.parseDouble(value));
                } else if (operator2 == '*') {
                    value1 = value1 * Math.pow(value2, Double.parseDouble(value));
                }
            }
        } catch (Exception e) {

        }
        numComplete = true;
        operator1 = '/';
        String result = Double.toString(value1);
        return result;
    }

    //When the power button (x^y) is pushed
    public static String powerPushed(String value) {
        try {
            if (operator1 == 'a') {
                value2 = Double.parseDouble(value);
            } else if (operator1 == '+') {
                operator2 = '+';
                value2 = Double.parseDouble(value);
            } else if (operator1 == '-') {
                operator2 = '-';
                value2 = Double.parseDouble(value);
            } else if (operator1 == '*') {
                operator2 = '*';
                value2 = Double.parseDouble(value);
            } else if (operator1 == '/') {
                operator2 = '/';
                value2 = Double.parseDouble(value);
            }
        } catch (Exception e) {

        }
        numComplete = true;
        operator1 = '^';
        String result = Double.toString(value2);
        return result;
    }

    //When the Equals button is pushed
    public static String equalsPushed(String value) {
        try {
            if (operator1 == 'a') {
                total = Double.parseDouble(value);
            } else if (operator1 == '+') {
                total = total + Double.parseDouble(value);
            } else if (operator1 == '-') {
                total = total - Double.parseDouble(value);
            } else if (operator1 == '*') {
                if (operator2 == '+') {
                    total = total + (value1 * Double.parseDouble(value));
                } else if (operator2 == '-') {
                    total = total - (value1 * Double.parseDouble(value));
                } else if (operator2 == 'a') {
                    total = value1 * Double.parseDouble(value);
                }
            } else if (operator1 == '/') {
                if (operator2 == '+') {
                    total = total + (value1 / Double.parseDouble(value));
                } else if (operator2 == '-') {
                    total = total - (value1 / Double.parseDouble(value));
                } else if (operator2 == 'a') {
                    total = value1 / Double.parseDouble(value);
                }
            } else if (operator1 == '^') {
                if (operator2 == 'a') {
                    total = Math.pow(value2, Double.parseDouble(value));
                } else if (operator2 == '+') {
                    total = total + Math.pow(value2, Double.parseDouble(value));
                } else if (operator2 == '-') {
                    total = total - Math.pow(value2, Double.parseDouble(value));
                } else if (operator2 == '*') {
                    total = total + value1 * Math.pow(value2, Double.parseDouble(value));
                } else if (operator2 == '/') {
                    total = total + value1 / Math.pow(value2, Double.parseDouble(value));
                }
            }
        } catch (Exception e) {

        }
        numComplete = true;
        operator1 = 'a';
        operator2 = 'a';
        String result = Double.toString(total);
        return result;

    }

    //@return the numComplete
    public boolean isNumComplete() {
        return numComplete;
    }

    //@param numComplete the numComplete to set
    public void setNumComplete(boolean numComplete) {
        this.numComplete = numComplete;
    }

    //Checks valid value entered and finds factorial of current display value
    public static String factorial(String display) {
        Calculations.numComplete = true;
        double value = Double.parseDouble(display);
        int result = 1;
        if (value > 20 || value < 0 || (value%1 != 0)) {
            throw new ArithmeticException();
        } else {
            for (int i = 1; i <= value; i++) {
                result *= i;
            }
            display = Integer.toString(result);
        }

        return display;

    }

    //Resets all variables to clear base calculation
    public static void reset() {
        total = 0;
        operator1 = 'a';
        operator2 = 'a';
        operator3 = 'a';
        value1 = 0.0;
        value2 = 0.0;
        numComplete = true;
    }

    //input = sin/cos/tan/etc, selected = deg(1) or rad(2), and value is display
    public static String degRadCalc(int input, int selected, String value) {
        double result = Double.parseDouble(value);
        
            if (selected == 1) {

                switch (input) {
                    case 1:
                        result = Math.toRadians(result);
                        result = Math.sin(result);
                        break;
                    case 2:
                        result = Math.toRadians(result);
                        result = Math.cos(result);
                        break;
                    case 3:
                        result = Math.toRadians(result);
                        result = Math.tan(result);
                        break;
                    case 4:
                        result = Math.asin(result);
                        result = Math.toDegrees(result);
                        break;
                    case 5:
                        result = Math.acos(result);
                        result = Math.toDegrees(result);
                        break;
                    case 6:
                        result = Math.atan(result);
                        result = Math.toDegrees(result);
                        break;
                }

            } else if (selected == 2) {
                switch (input) {
                    case 1:
                        result = Math.sin(result);
                        break;
                    case 2:
                        result = Math.cos(result);
                        break;
                    case 3:
                        result = Math.tan(result);
                        break;
                    case 4:
                        result = Math.asin(result);
                        break;
                    case 5:
                        result = Math.acos(result);
                        break;
                    case 6:
                        result = Math.atan(result);
                        break;
                }
            }
        
        Calculations.numComplete = true;
        return String.valueOf(result);
    }
    
    

}
