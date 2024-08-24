package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "ARisMove (Blocks to Java)")
public class Testing extends LinearOpMode {

    private DcMotor marm;
    private Servo kepperarm;
    private Servo reser;
    private Servo gripper;
    private DcMotor m1;
    private DcMotor m2;
    private DcMotor m3;
    private DcMotor m4;

    double SPD;
    double turnspd;

    /**
     * This function is executed when this OpMode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        marm = hardwareMap.get(DcMotor.class, "marmAsDcMotor");
        kepperarm = hardwareMap.get(Servo.class, "kepper arm");
        reser = hardwareMap.get(Servo.class, "reser");
        gripper = hardwareMap.get(Servo.class, "gripper");
        m1 = hardwareMap.get(DcMotor.class, "m1");
        m2 = hardwareMap.get(DcMotor.class, "m2");
        m3 = hardwareMap.get(DcMotor.class, "m3");
        m4 = hardwareMap.get(DcMotor.class, "m4");

        // Put initialization blocks here.
        sleep(1000);
        kepperarm.setDirection(Servo.Direction.REVERSE);
        reser.setDirection(Servo.Direction.REVERSE);
        gripper.setDirection(Servo.Direction.FORWARD);
        SPD = 0.32;
        turnspd = 0.3;
        turnspd = 0.3;
        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {
                // SPD setting
                if (gamepad1.y) {
                    SPD = 0.45;
                    turnspd = 0.3;
                } else if (gamepad1.a) {
                    SPD = 1;
                    turnspd = 0.3;
                }
                // Movement controling
                if (gamepad1.dpad_up) {
                    Forward();
                } else if (gamepad1.b) {
                    TurnR();
                } else if (gamepad1.x) {
                    TurnL();
                } else if (gamepad1.dpad_down) {
                    Backward();
                } else if (gamepad1.dpad_right) {
                    Move_R();
                } else if (gamepad1.right_bumper) {
                    Forward_R();
                } else if (gamepad1.left_trigger > 0.1) {
                    Backward_L();
                } else if (gamepad1.left_bumper) {
                    Forward_L();
                } else if (gamepad1.right_trigger > 0.1) {
                    Backward_R();
                } else if (gamepad1.dpad_left) {
                    Move_L();
                } else {
                    Stop();
                }
            }
        }
    }

    /**
     * Describe this function...
     */
    private void Stop() {
        m1.setPower(0);
        m2.setPower(0);
        m3.setPower(0);
        m4.setPower(0);
    }

    /**
     * Describe this function...
     */
    private void Backward() {
        m1.setPower(SPD);
        m2.setPower(SPD);
        m3.setPower(SPD);
        m4.setPower(SPD);
    }

    /**
     * Describe this function...
     */
    private void TurnL() {
        m1.setPower(turnspd);
        m4.setPower(turnspd);
        m2.setPower(-turnspd);
        m3.setPower(-turnspd);
    }

    /**
     * Describe this function...
     */
    private void Forward() {
        m1.setPower(-SPD);
        m2.setPower(-SPD);
        m3.setPower(-SPD);
        m4.setPower(-SPD);
    }

    /**
     * Describe this function...
     */
    private void TurnR() {
        m2.setPower(turnspd);
        m3.setPower(turnspd);
        m1.setPower(-turnspd);
        m4.setPower(-turnspd);
    }

    /**
     * Describe this function...
     */
    private void Move_R() {
        m1.setPower(-SPD);
        m3.setPower(-SPD);
        m2.setPower(SPD);
        m4.setPower(SPD);
    }

    /**
     * Describe this function...
     */
    private void Move_L() {
        m1.setPower(SPD);
        m3.setPower(SPD);
        m2.setPower(-SPD);
        m4.setPower(-SPD);
    }

    /**
     * Describe this function...
     */
    private void Backward_L() {
        m1.setPower(SPD);
        m3.setPower(SPD);
    }

    /**
     * Describe this function...
     */
    private void Forward_R() {
        m1.setPower(-SPD);
        m3.setPower(-SPD);
    }

    /**
     * Describe this function...
     */
    private void Backward_R() {
        m2.setPower(SPD);
        m4.setPower(SPD);
    }

    /**
     * Describe this function...
     */
    private void Forward_L() {
        m2.setPower(-SPD);
        m4.setPower(-SPD);
    }
}