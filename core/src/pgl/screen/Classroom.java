package pgl.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.colouredtulips.BaseScreen;
import com.colouredtulips.Constants;
import com.colouredtulips.object.CustomSprite;
import com.colouredtulips.object.SkeletonAnimation;


/**
 * Created by rizkisunaryo on 1/14/15.
 */
public class Classroom extends BaseScreen {
    private SkeletonAnimation teacher;
    private SkeletonAnimation student2;
    private CustomSprite emptyTable;
    private SkeletonAnimation student3;
    private SkeletonAnimation student4;
    private CustomSprite historyBook;
    private SkeletonAnimation mainGirl;
    private SkeletonAnimation mainGirlFake;



    @Override
    public void resize(int width, int height) {
        super.resize(width,height);
    }
    @Override
    public void dispose() {
        super.dispose();
    }

    public Classroom() {
        super();

        midBg = new CustomSprite("classroom_midBg.png",650,341,1.5f);
        bg = new CustomSprite("classroom_bg.png",
                Constants.STANDARD_BG_X,
                Constants.STANDARD_BG_Y,
                Constants.STANDARD_BG_SCALE);

        teacher=new SkeletonAnimation(renderer, "teacher", 0.75f, 325, 117, "breath");
        student2=new SkeletonAnimation(renderer, "student2", 0.7f, 760, 147, "breath");
        emptyTable = new CustomSprite("classroom_empty_table.png", 442, 35);
        student4=new SkeletonAnimation(renderer, "student4", 1.4f, 1090, 180, "breathing");
        student3=new SkeletonAnimation(renderer, "student3", 0.7f, 1090, 35, "breath_bookclose");
        historyBook = new CustomSprite("classroom_book1.png", 565, 300);
        mainGirl=new SkeletonAnimation(renderer, "main_school_girl", 0.7f, 884, 10, "walking");
        mainGirlFake=new SkeletonAnimation(renderer, "main_school_girl", 0.7f, 884, 10, "walking");

        midBgGroup = new Group();
        midBgGroup.addActor(midBg);
        stage.addActor(midBgGroup);
        midBgAccelSpeed =15f;

        bgGroup = new Group();
        bgGroup.addActor(bg);
        stage.addActor(bgGroup);
        bgAccelSpeed =10f;

        foregroundGroup = new Group();
        foregroundGroup.addActor(teacher);
        foregroundGroup.addActor(student2);
        foregroundGroup.addActor(emptyTable);
        foregroundGroup.addActor(student4);
        foregroundGroup.addActor(student3);
        foregroundGroup.addActor(historyBook);
        foregroundGroup.addActor(mainGirl);
//        stage.addActor(mainGirl);
        stage.addActor(foregroundGroup);
        foregroundAccelSpeed =5f;
    }

    @Override
    public void render(float delta) {
        updateAnimations();

        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        applyAnimations();

        camera.update();

        batch.begin();
        batch.setProjectionMatrix(camera.combined);

        batch.end();

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        System.out.println("test: " + mainGirl.getX()+":"+mainGirl.getY());

//        renderer.draw(batch,teacher.getSkeleton());


//        renderer.draw(batch,mainGirl.getSkeleton());

//        Gdx.input.vibrate(1000);
        xAccel =-Gdx.input.getAccelerometerY();
        yAccel =Gdx.input.getAccelerometerX();
//        moveByAcceleration();



//        System.out.println(mainGirl.getWidth()+":"+mainGirl.getHeight());
    }
}