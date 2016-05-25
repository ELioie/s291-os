/*
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dot.junit.opcodes.invoke_super_range;

import dot.junit.DxTestCase;
import dot.junit.DxUtil;
import dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_1;
import dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_10;
import dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_14;
import dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_15;
import dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_17;
import dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_18;
import dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_19;
import dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_2;
import dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_20;
import dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_24;
import dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_4;
import dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_5;
import dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_6;
import dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_7;

public class Test_invoke_super_range extends DxTestCase {

    /**
     * @title invoke method of superclass
     */
    public void testN1() {
        //@uses dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_1
        //@uses dot.junit.opcodes.invoke_super_range.d.TSuper
        T_invoke_super_range_1 t = new T_invoke_super_range_1();
        assertEquals(5, t.run());
    }


    /**
     * @title Invoke protected method of superclass
     */
    public void testN3() {
        //@uses dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_7
        //@uses dot.junit.opcodes.invoke_super_range.d.TSuper
        T_invoke_super_range_7 t = new T_invoke_super_range_7();
        assertEquals(5, t.run());
    }

    /**
     * @title Check that new frame is created by invoke_super_range and
     * arguments are passed to method
     */
    public void testN5() {
        //@uses dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_14
        //@uses dot.junit.opcodes.invoke_super_range.d.TSuper
        T_invoke_super_range_14 t = new T_invoke_super_range_14();
        assertTrue(t.run());
    }

    /**
     * @title Recursion of method lookup procedure
     */
    public void testN6() {
        //@uses dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_17
        //@uses dot.junit.opcodes.invoke_super_range.d.TSuper
        //@uses dot.junit.opcodes.invoke_super_range.d.TSuper2
        T_invoke_super_range_17 t = new T_invoke_super_range_17();
        assertEquals(5, t.run());
    }

    /**
     * @title obj ref is null
     */
    public void testE1() {
        //@uses dot.junit.opcodes.invoke_super_range.d.TSuper
        loadAndRun("dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_2",
                   NullPointerException.class);
    }

    /**
     * @title Native method can't be linked
     */
    public void testE2() {
        //@uses dot.junit.opcodes.invoke_super_range.d.TSuper
        loadAndRun("dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_4",
                   UnsatisfiedLinkError.class);
    }

    /**
     * @title Attempt to invoke abstract method
     */
    public void testE4() {
        //@uses dot.junit.opcodes.invoke_super_range.ATest
        loadAndRun("dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_6",
                   AbstractMethodError.class);
    }

    /**
     * @constraint A14
     * @title invalid constant pool index
     */
    public void testVFE1() {
        load("dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_8", VerifyError.class);
    }

    /**
     * @constraint A15
     * @title &lt;clinit&gt; may not be called using invoke-super
     */
    public void testVFE3() {
        load("dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_10", VerifyError.class);
    }

    /**
     * @constraint B1
     * @title number of arguments passed to method
     */
    public void testVFE4() {
        load("dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_11", VerifyError.class);
    }

    /**
     * @constraint B9
     * @title types of arguments passed to method.
     */
    public void testVFE5() {
        //@uses dot.junit.opcodes.invoke_super_range.d.TSuper
        load("dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_12", VerifyError.class);
    }

    /**
     * @constraint A15
     * @title &lt;init&gt; may not be called using invoke_super_range
     */
    public void testVFE6() {
        load("dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_16", VerifyError.class);
    }

    /**
     * @constraint B10
     * @title assignment incompatible references when accessing
     *                  protected method
     */
    public void testVFE8() {
        //@uses dot.junit.opcodes.invoke_super_range.d.TSuper
        //@uses dot.junit.opcodes.invoke_super_range.d.TPlain
        load("dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_22", VerifyError.class);
    }

    /**
     * @constraint B10
     * @title assignment incompatible references when accessing
     *                  public method
     */
    public void testVFE9() {
        //@uses dot.junit.opcodes.invoke_super_range.d.TSuper
        //@uses dot.junit.opcodes.invoke_super_range.d.TSuper2
        load("dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_23", VerifyError.class);
    }

    /**
     * @constraint n/a
     * @title Attempt to call static method.
     */
    public void testVFE10() {
        //@uses dot.junit.opcodes.invoke_super_range.d.TSuper
        loadAndRun("dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_5",
                   IncompatibleClassChangeError.class);
    }


    /**
     * @constraint n/a
     * @title Attempt to invoke non-existing method.
     */
    public void testVFE12() {
        loadAndRun("dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_15",
                   NoSuchMethodError.class);
    }

    /**
     * @constraint n/a
     * @title Attempt to invoke private method of other class.
     */
    public void testVFE13() {
        //@uses dot.junit.opcodes.invoke_super_range.TestStubs
        loadAndRun("dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_18",
                   IllegalAccessError.class, new TestStubs());
    }

    /**
     * @constraint B12
     * @title Attempt to invoke protected method of unrelated class.
     */
    public void testVFE14() {
        //@uses dot.junit.opcodes.invoke_super_range.TestStubs
        loadAndRun("dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_20",
                   IllegalAccessError.class, new TestStubs());
    }

    /**
     * @constraint n/a
     * @title Method has different signature.
     */
    public void testVFE15() {
        //@uses dot.junit.opcodes.invoke_super_range.d.TSuper
        loadAndRun("dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_19",
                   NoSuchMethodError.class);
    }

    /**
     * @constraint n/a
     * @title invoke-super/range shall be used to invoke private methods
     */
    public void testVFE16() {
        //@uses dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_13
        //@uses dot.junit.opcodes.invoke_super_range.d.TSuper
        load("dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_13", VerifyError.class);
    }

    /**
     * @constraint A23
     * @title number of registers
     */
    public void testVFE17() {
        load("dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_9", VerifyError.class);
    }

    /**
     * @constraint A14
     * @title attempt to invoke interface method
     */
    public void testVFE18() {
        //@uses dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_24
        loadAndRun("dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_24",
                   IncompatibleClassChangeError.class);
    }

    /**
     * @constraint B6
     * @title instance methods may only be invoked on already initialized instances.
     */
    public void testVFE19() {
        //@uses dot.junit.opcodes.invoke_super_range.d.TSuper
        load("dot.junit.opcodes.invoke_super_range.d.T_invoke_super_range_25", VerifyError.class);
    }

}
