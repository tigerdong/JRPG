/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package squarepg;

/**
 *
 * @author Cathy
 */
public interface IState {
    public void Update (float elapsedTime);
    public void Render();
    public void OnEnter();
    public void OnExit();
}

