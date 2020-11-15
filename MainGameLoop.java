package engineTester;

import org.lwjgl.opengl.Display;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;

public class MainGameLoop
{
    /**
     * Creates the display and continuously updates the display until user closes.
     * @param args
     *
     * https://www.youtube.com/watch?v=z2yFlvkBbmk&list=PLRIWtICgwaX0u7Rf9zkZhLoLuZVfUksDP&index=3
     *
     * @author Hexers
     */
    public static void main(String[] args) {
        DisplayManager.createDisplay();

        Loader loader = new Loader();
        Renderer renderer = new Renderer();

        // OpenGL expects verticies to be defined counter clockwise by default
        float[] verticies =
                {
                        // Left bottom triangle
                        -0.5f, 0.5f, 0f,
                        -0.5f, -0.5f, 0f,
                        -0.5f, -0.5f, 0f,
                        // Right top triangle
                        0.5f, -0.5f, 0f,
                        0.5f, 0.5f, 0f,
                        -0.5f, 0.5f, 0f
                };

        RawModel model = loader.loadToVAO(verticies);


        while(!Display.isCloseRequested())
        {
            renderer.prepare();
            // game logic
            renderer.render(model);
            DisplayManager.updateDisplay();
        }

        loader.cleanUp();
        DisplayManager.closeDisplay();
    }
}
